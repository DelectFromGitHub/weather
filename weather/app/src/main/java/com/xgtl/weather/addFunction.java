package com.xgtl.weather;
import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;
import java.util.Date;


public class addFunction extends AppCompatActivity implements CustomError{
    TextView calendar, inappropriate, avoidInappropriate;
    public void into() {
        View view = View.inflate(this, R.layout.laohangli_add, null);
        calendar = view.findViewById(R.id.calendar);
        inappropriate = view.findViewById(R.id.inappropriate);
        avoidInappropriate = view.findViewById(R.id.avoid_inappropriate);
        Button historyIv = findViewById(R.id.history);
        Button HuangLiIv = findViewById(R.id.HuangLi);
        Button uploadIv = findViewById(R.id.upload);
        //历史上的今天-------点击事件
        historyIv.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                Date date = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("MM");
                SimpleDateFormat sdf2 = new SimpleDateFormat("dd");
                String url = "http://www.jiahengfei.cn:33550/port/history?dispose=easy&key=jiahengfei&month="+sdf.format(date)+"&day="+sdf2.format(date);
                loadData(url);
            }
        });
        //老黄历--------点击事件
        HuangLiIv.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                Date date = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
                String url = "http://v.juhe.cn/laohuangli/d?date=" + sdf.format(date) + "&key=c7c6d7da1062f007a33609571cdb17f2";
                    loadData(url);
            }
        });
        uploadIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
    //请求网络操作
    public void loadData(String url){
        RequestParams params = new RequestParams(url);
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Intent intent = new Intent(addFunction.this,MainActivity.class);
                intent.putExtra("result",result);
                startActivity(intent);
            }
            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
            }
            @Override
            public void onCancelled(CancelledException cex) {}
            @Override
            public void onFinished() {}
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_function);
        into();
    }

}
