package com.xgtl.weather;


import android.support.v4.app.Fragment;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;


public class BaseFragent extends Fragment implements Callback.CommonCallback<String> {
    public void loadData(String path) {
        RequestParams params = new RequestParams(path);
        x.http().get(params, this);
    }

    //获取数据成功时后回调的窗口
    @Override
    public void onSuccess(String result) {
    }

    //获取数据失败时回调的窗口
    @Override
    public void onError(Throwable ex, boolean isOnCallback) {
    }

    //取消请求时调用的接口
    @Override
    public void onCancelled(CancelledException cex) {
    }

    //请求完成时调用的接口
    @Override
    public void onFinished() {
    }
}
