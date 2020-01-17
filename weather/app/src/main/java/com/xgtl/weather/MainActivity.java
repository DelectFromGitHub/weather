package com.xgtl.weather;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.gson.Gson;
import com.xgtl.weather.Bean.bean.History;
import com.xgtl.weather.Bean.bean.LaoHuangLi;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView addCityIv, moreIv;//表示添加更多形式的  跳转到更多的添加页面
    TextView calendar,inappropriate,avoidInappropriate;
    LinearLayout addLayoutIv;
    ViewPager mainVp;
    Button addIv, deleIv;
    RadioGroup radioGroupIv;
    //    数据源
    List<Fragment> fragmentList = new ArrayList<>();
    //显示的城市
    ArrayList<String> cityList = new ArrayList<>();
    //页数
    /*window*/
    private View v;
    private PopupWindow window;
    private CityFragmentPageAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        v = View.inflate(this, R.layout.activity_delect, null);
        window = new PopupWindow(v, 1800, 300);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addCityIv = findViewById(R.id.main_iv_add);
        moreIv = findViewById(R.id.main_iv_more);
        mainVp = findViewById(R.id.main_vp);
        //添加点击事件
        addCityIv.setOnClickListener(this);
        moreIv.setOnClickListener(this);
        if (cityList.size() == 0) {
            cityList.add("来宾");
        }
        //初始化
        initPager();
        adapter = new CityFragmentPageAdapter(getSupportFragmentManager(), fragmentList);
        mainVp.setAdapter(adapter);
    }


    private void initPager() {
        for (int i = 0; i < cityList.size(); i++) {
            CityWeatherBlankFragment cwFrag = new CityWeatherBlankFragment();
            Bundle bundle = new Bundle();
            bundle.putString("city", cityList.get(i));
            cwFrag.setArguments(bundle);
            fragmentList.add(cwFrag);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.main_iv_add:
                if (cityList.size() >= 3) {
                    AlertDialog alertDialog = new AlertDialog.Builder(this).setTitle("以经到达上限了").create();
                    alertDialog.show();
                } else {
                    Intent intent = new Intent(MainActivity.this, AddCity.class);
                    intent.putExtra("msg", "北京");
                    startActivity(intent);
                }
                break;
            case R.id.main_iv_more:
                into(v);
        }
    }

    private void into(View view) {
        addIv = view.findViewById(R.id.add_functionality);
        deleIv = view.findViewById(R.id.delect_city);
        addLayoutIv = findViewById(R.id.add_layout);
        radioGroupIv = view.findViewById(R.id.radio);
        /*如果sum！=0则表示不是第一次点击*/
        System.out.println(window);
        if (window.isShowing()) {
            window.dismiss();
        } else {
            window.showAsDropDown(addIv, -100, 10);
        }
        //添加功能
        addIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, addFunction.class);
                startActivity(intent);
            }
        });
        //删除城市
        deleIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, delectCity.class);
                distinct();
                intent.putStringArrayListExtra("city", cityList);
                startActivity(intent);
            }
        });
    }

    //去除cityList中重复的值
    private void distinct() {
        for (int i = 0; i < cityList.size(); i++) {
            for (int j = 0; j < cityList.size(); j++) {
                if (i != j && cityList.get(i).equals(cityList.get(j))) {
                    cityList.remove(cityList.get(j));
                }
            }
        }
    }


    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        distinct();
        String city = intent.getStringExtra("city");
        if (city != null) {
            addCity(city);
        }

        String citys = intent.getStringExtra("citys");
        if (citys != null) {
            distinct();
            System.out.println(cityList);
            if (cityList.size() != 0) {
                //删除选中的城市
                cityList.remove(citys);
                //清空fragmentList中的内容
                fragmentList.clear();
                //清空adapter中的内容
                adapter.notifyDataSetChanged();
                for (String c : cityList) {
                    CityWeatherBlankFragment fragment = new CityWeatherBlankFragment();
                    Bundle args = new Bundle();
                    args.putString("city", c);
                    fragment.setArguments(args);
                    //将cityList中剩余的城市倒灌到fragmentList中
                    fragmentList.add(fragment);
                    adapter.notifyDataSetChanged();
                    //将fragmentList放到adapter中
                    adapter = new CityFragmentPageAdapter(getSupportFragmentManager(), fragmentList);
                    mainVp.setAdapter(adapter);
                    window.dismiss();
                }
            }
            if (cityList.size() == 1) {
                AlertDialog alertDialog = new AlertDialog.Builder(this)
                        .setTitle("只剩下一个城市了")
                        .setNegativeButton("我知道了", new DialogInterface.OnClickListener() {//添加取消
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                            }
                        }).create();
                alertDialog.show();
            }
        }
        String result = intent.getStringExtra("result");
        if (result!=null){
            addLayoutIv.setVisibility(View.VISIBLE);
            parseShowData(result);
        }
    }
    //老黄历
    private void parseShowData(String result) {
       try {
           View v = View.inflate(this, R.layout.laohangli_add, null);LaoHuangLi laoHuangLi = new Gson().fromJson(result, LaoHuangLi.class);
           LaoHuangLi.ResultBean resultBean = laoHuangLi.getResult();
           if (resultBean.getJi().equals("")){
               int i = 0-1;
           }
           calendar = v.findViewById(R.id.calendar);
           inappropriate = v.findViewById(R.id.inappropriate);
           avoidInappropriate = v.findViewById(R.id.avoid_inappropriate);
           addLayoutIv.addView(v);
           calendar.setText(resultBean.getYinli());
           inappropriate.setText(resultBean.getYi());
           avoidInappropriate.setText(resultBean.getJi());
       }catch (Exception e){
           History history = new Gson().fromJson(result,History.class);
           List<History.DataBean> dataBean = history.getData();
            for (int i=0;i<dataBean.size();i++){
                View view = View.inflate(this,R.layout.history_add,null);
                addLayoutIv.addView(view);
                TextView dateIv = view.findViewById(R.id.date);
                TextView safeness = view.findViewById(R.id.safeness);
                History.DataBean bean = dataBean.get(i);
                dateIv.setText(bean.getYear());
                safeness.setText(bean.getTitle());
            }
       }
    }

    //添加城市
    private void addCity(String city) {
        cityList.add(city);
        CityWeatherBlankFragment fragment = new CityWeatherBlankFragment();
        Bundle args = new Bundle();
        args.putString("city", city);
        fragment.setArguments(args);
        fragmentList.add(fragment);
        adapter.notifyDataSetChanged();
    }
}
