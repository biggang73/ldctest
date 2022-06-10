package com.fish.ab.base.vm;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;


import com.fish.ab.base.bean.DialogBean;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;


public abstract class BaseViewModel extends ViewModel {

    /**
     * 管理RxJava请求
     */
    private CompositeDisposable compositeDisposable;
    /**
     * 用来通知 Activity／Fragment 是否显示等待Dialog
     */
    protected DialogLiveData<DialogBean> showDialog = new DialogLiveData<>();
    /**
     * 当ViewModel层出现错误需要通知到Activity／Fragment
     */
    protected MutableLiveData<Object> error = new MutableLiveData<>();

    protected MutableLiveData<Object> back = new MutableLiveData<>();

    protected MutableLiveData<Object> menu = new MutableLiveData<>();

    /**
     * 添加 rxJava 发出的请求
     */
    protected void addDisposable(Disposable disposable) {
        if (compositeDisposable == null || compositeDisposable.isDisposed()) {
            compositeDisposable = new CompositeDisposable();
        }
        compositeDisposable.add(disposable);
    }

    public void getShowDialog(LifecycleOwner owner, Observer<DialogBean> observer) {
        showDialog.observe(owner, observer);
    }

    public void getError(LifecycleOwner owner, Observer<Object> observer) {
        error.observe(owner, observer);
    }

    public void getBack(LifecycleOwner owner, Observer<Object> observer) {
        back.observe(owner, observer);
    }

    public void getMenu(LifecycleOwner owner, Observer<Object> observer) {
        menu.observe(owner, observer);
    }


    /**
     * ViewModel销毁同时也取消请求
     */
    @Override
    protected void onCleared() {
        super.onCleared();
        if (compositeDisposable != null) {
            compositeDisposable.dispose();
            compositeDisposable = null;
        }
        showDialog = null;
        error = null;
        back = null;
        menu = null;
    }

}
