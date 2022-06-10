package com.fish.ab.app.vm;


import android.view.View;

import com.fish.ab.base.vm.BaseViewModel;


public class BaseTitleViewModel extends BaseViewModel {

    public String getTitle() {
        return title;
    }

    public String title;

    public boolean backflag = true;
    public boolean menuflag = false;

    /*
     * 初始化的页面title
     */
    public void setTitle(String data) {
        this.title = data;
    }

    /*
     * 登录成功保存页面数据
     */
    public void back(View view) {
        back.setValue(backflag);
    }

    public void menu(View view) {
        menu.setValue(menuflag);
    }

}
