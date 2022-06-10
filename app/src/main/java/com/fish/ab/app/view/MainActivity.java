package com.fish.ab.app.view;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import com.fish.ab.R;
import com.fish.ab.app.vm.BaseTitleViewModel;
import com.fish.ab.app.vm.MainViewModel;
import com.fish.ab.base.MyApplication;
import com.fish.ab.base.vm.BaseActivity;
import com.fish.ab.databinding.ActivityMainBinding;

public class MainActivity extends BaseActivity<MainViewModel, ActivityMainBinding> {

    private String TAG = "MainActivity";

    private static boolean mFlag;
    public static void start(Context context, boolean flag) {
        mFlag = flag;
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected int onCreate() {
        // 绑定页面数据
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {

        dataBinding.loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MyApplication.CONTEXT, "loginBtn clicked", Toast.LENGTH_SHORT).show();
                LoginActivity.start(MainActivity.this, true);

            }
        });

//        dataBinding.registerButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(MyApplication.CONTEXT, "registerBtn clicked", Toast.LENGTH_SHORT).show();
//                RegisterActivity.start(MainActivity.this, true);
//            }
//        });

    }

    @Override
    protected void initData() {

    }

    @Override
    protected MainViewModel initViewModel() {
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

}
