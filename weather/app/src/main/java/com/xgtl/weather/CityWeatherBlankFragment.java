package com.xgtl.weather;


import android.app.AlertDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.squareup.picasso.Picasso;
import com.xgtl.weather.Bean.bean.WeatherBean;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class CityWeatherBlankFragment extends BaseFragent implements View.OnClickListener {
    TextView tempTv, cityTv, conditonTv, windTv, tempRangTv, dateTv, colthTv, carIndexTv, coldTv, sportIndexTv, raysIndexTv;
    ImageView dayIv;
    LinearLayout futreLayout;
    String url1 = "http://api.map.baidu.com/telematics/v3/weather?location=";
    String url2 = "&output=json&ak=FkPhtMBK0HTIQNh7gG4cNUttSTyr0nzo";
    private List<WeatherBean.ResultsBean.IndexBean> indexList;

    public CityWeatherBlankFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_weather, container, false);
        initView(view);
        //可以通过activity传值地区的天气情况
        Bundle bundle = getArguments();
        if (bundle == null) {
            bundle = new Bundle();
            bundle.putString("city", "来宾");
        }
        String city = bundle.getString("city");
        String url = url1 + city + url2;
        /*调用父类接口*/
        loadData(url);
        return view;
    }

    //成功以后调用方法
    @Override
    public void onSuccess(String result) {
        //解析数据
        parseShowData(result);
    }

    //失败以后调用方法
    @Override
    public void onError(Throwable ex, boolean isOnCallback) {
    }

    private void parseShowData(String result) {
        //使用gson解析数据
        WeatherBean weatherBean = new Gson().fromJson(result, WeatherBean.class);
        WeatherBean.ResultsBean resultsBean = weatherBean.getResults().get(0);
        WeatherBean.ResultsBean.WeatherDataBean todayDateBeat = resultsBean.getWeather_data().get(0);
        //获取指数信息列表
        this.indexList = resultsBean.getIndex();
        dateTv.setText(weatherBean.getDate());
        cityTv.setText(resultsBean.getCurrentCity());
        windTv.setText(todayDateBeat.getWind());
        tempRangTv.setText(todayDateBeat.getTemperature());
        //获取实时天气情况，需要获取字符串
        String[] split = todayDateBeat.getDate().split("：");
        String todayTemp = split[1].replace(")", "");
        tempTv.setText(todayTemp);
        //天气图片
        Picasso.with(getActivity()).load(todayDateBeat.getDayPictureUrl()).into(dayIv);
        List<WeatherBean.ResultsBean.WeatherDataBean> futreList = resultsBean.getWeather_data();
        futreList.remove(0);
        for (int i = 0; i < futreList.size(); i++) {
            View view = LayoutInflater.from(getActivity()).inflate(R.layout.item_main_center, null);
            view.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            futreLayout.addView(view);
            TextView idteTv = view.findViewById(R.id.item_tv_date);
            TextView iconTv = view.findViewById(R.id.item_tv_con);
            TextView itemprangTv = view.findViewById(R.id.item_tv_temp);
            ImageView iTv = view.findViewById(R.id.item_center_iv);
            //获取对应的位置的天气情况
            //未来几天的天气
            WeatherBean.ResultsBean.WeatherDataBean weatherDataBean = futreList.get(i);
            idteTv.setText(weatherDataBean.getDate());
            iconTv.setText(weatherDataBean.getWeather());
            itemprangTv.setText(weatherDataBean.getTemperature());
            //获取网络图片
            Picasso.with(getActivity()).load(weatherDataBean.getDayPictureUrl()).into(iTv);
        }
    }

    private void initView(View view) {
        //初始化控件操作
        tempTv = view.findViewById(R.id.frag_tv_currenttemp);
        cityTv = view.findViewById(R.id.frag_tv_city);
        conditonTv = view.findViewById(R.id.frag_iv_dress);
        windTv = view.findViewById(R.id.frag_tv_wind);
        tempRangTv = view.findViewById(R.id.frag_tv_leftTemperature);
        dateTv = view.findViewById(R.id.frag_tv_date);
        colthTv = view.findViewById(R.id.frag_tv_intercept);
        carIndexTv = view.findViewById(R.id.frag_iv_washcar);
        coldTv = view.findViewById(R.id.frag_iv_cole);
        sportIndexTv = view.findViewById(R.id.frag_iv_sprot);
        raysIndexTv = view.findViewById(R.id.frag_iv_rays);
        dayIv = view.findViewById(R.id.frag_iv_today);

        futreLayout = view.findViewById(R.id.frag_center_layout);
        //设置点击事件
        conditonTv.setOnClickListener(this);
        carIndexTv.setOnClickListener(this);
        coldTv.setOnClickListener(this);
        sportIndexTv.setOnClickListener(this);
        raysIndexTv.setOnClickListener(this);
    }

    public void onClick(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        switch (v.getId()) {
            case R.id.frag_iv_dress:
                builder.setTitle("穿衣指数");
                WeatherBean.ResultsBean.IndexBean indexBean = indexList.get(0);
                String msg = indexBean.getZs() + "/n" + indexBean.getDes();
                builder.setMessage(msg);
                builder.setPositiveButton("确定", null);
                break;
            case R.id.frag_iv_washcar:
                builder.setTitle("洗车指数");
                indexBean = indexList.get(1);
                msg = indexBean.getZs() + "/n" + indexBean.getDes();
                builder.setMessage(msg);
                builder.setPositiveButton("确定", null);
                break;
            case R.id.frag_iv_cole:
                builder.setTitle("感冒指数");
                indexBean = indexList.get(2);
                msg = indexBean.getZs() + "/n" + indexBean.getDes();
                builder.setMessage(msg);
                builder.setPositiveButton("确定", null);
                break;
            case R.id.frag_iv_sprot:
                builder.setTitle("运动指数");
                indexBean = indexList.get(3);
                msg = indexBean.getZs() + "/n" + indexBean.getDes();
                builder.setMessage(msg);
                builder.setPositiveButton("确定", null);
                break;
            case R.id.frag_iv_rays:
                builder.setTitle("紫外线指数");
                indexBean = indexList.get(4);
                msg = indexBean.getZs() + "/n" + indexBean.getDes();
                builder.setMessage(msg);
                builder.setPositiveButton("确定", null);
                break;
        }

        builder.create().show();
    }

}
