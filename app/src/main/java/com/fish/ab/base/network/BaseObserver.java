package com.fish.ab.base.network;

import android.util.Log;


import com.fish.ab.base.bean.BaseEntity;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public abstract class BaseObserver implements Observer<BaseEntity> {
    @Override
    public void onSubscribe(Disposable disposable) {

    }

    @Override
    public void onError(Throwable throwable) {
        Log.i("错误", "onError: " + throwable.getMessage());
//        Toast.makeText(MyApplication.CONTEXT, "服务器请求异常", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNext(BaseEntity responseBody) {
        if (responseBody != null) {

        }
    }

    @Override
    public void onComplete() {
        Log.i("onComplete", "onComplete: ");
    }

}
