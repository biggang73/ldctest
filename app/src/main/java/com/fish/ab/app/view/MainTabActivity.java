package com.fish.ab.app.view;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.fish.ab.R;
import com.fish.ab.app.vm.BaseTitleViewModel;
import com.fish.ab.app.vm.MainTabViewModel;
import com.fish.ab.base.vm.BaseActivity;
import com.fish.ab.databinding.ActivityMainTabBinding;

public class MainTabActivity extends BaseActivity<MainTabViewModel, ActivityMainTabBinding> {


    private String TAG = "MainTabActivity";

    public static void start(Context context) {
        Intent intent = new Intent(context, MainTabActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected int onCreate() {
        // 绑定页面数据
        return R.layout.activity_main_tab;
    }

    @Override
    protected MainTabViewModel initViewModel() {
        return null;
    }

    @Override
    protected BaseTitleViewModel initTitleVM() {
        return null;
    }

    @Override
    protected void showError(Object obj) {

    }

    @Override
    protected void getBack(Object obj) {

    }

    @Override
    protected void getMenu(Object obj) {

    }


    @Override
    protected void initView() {

        dataBinding.llOrganization.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(MyApplication.CONTEXT, "loginOut clicked", Toast.LENGTH_SHORT).show();
                FsuAreaViewActivity.start(MainTabActivity.this);
            }
        });


//        dataBinding.loginOut.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(MyApplication.CONTEXT, "loginOut clicked", Toast.LENGTH_SHORT).show();
//                LoginActivity.start(MainTabActivity.this, true);
//            }
//        });

    }

    @Override
    protected void initData() {

    }
}
