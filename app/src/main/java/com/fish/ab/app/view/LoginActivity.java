package com.fish.ab.app.view;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import androidx.lifecycle.ViewModelProvider;
import com.fish.ab.R;
import com.fish.ab.app.bean.login.UserInfo;
import com.fish.ab.app.vm.BaseTitleViewModel;
import com.fish.ab.app.vm.LoginViewModel;
import com.fish.ab.base.Consts;
import com.fish.ab.base.util.PreferenceUtil;
import com.fish.ab.base.vm.BaseActivity;
import com.fish.ab.databinding.ActivityLoginBinding;

public class LoginActivity extends BaseActivity<LoginViewModel, ActivityLoginBinding> {
    private String TAG = "LoginActivity";

    private static boolean mFlag;

    public static void start(Context context, boolean flag) {
        mFlag = flag;
        Intent intent = new Intent(context, LoginActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected int onCreate() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {
    }

    @Override
    protected void initData() {
        dataBinding.setModel(this);

        String isCick = PreferenceUtil.getInstance().getData("isCick", "", false);

        if (mFlag) {
            if ("1".equalsIgnoreCase(isCick)) {
                String name = PreferenceUtil.getInstance().getData("name", "", false);
                String pwd = PreferenceUtil.getInstance().getData("pwd", "", false);

                dataBinding.etUser.setText(name);
                dataBinding.etPassword.setText(pwd);

                viewModel.loginAuthentication(name, pwd, Consts.IMEI);

                dataBinding.cbRememberPassword.setChecked(true);

            } else {
                dataBinding.cbRememberPassword.setChecked(false);
            }
        }
    }

    @Override
    protected void getMenu(Object obj) {
    }

    @Override
    protected void getBack(Object obj) {
        finish();
    }

    @Override
    protected LoginViewModel initViewModel() {
        return new ViewModelProvider(this).get(LoginViewModel.class);
    }

    @Override
    protected BaseTitleViewModel initTitleVM() {
        return null;
    }

    @Override
    protected void showError(Object obj) {
        String t = (String) obj;

        if (t != null) {
            if (dataBinding.cbRememberPassword.isChecked()) {
                String name = dataBinding.etUser.getText().toString();
                String pwd = dataBinding.etPassword.getText().toString();
                PreferenceUtil.getInstance().setData("name", name, false);
                PreferenceUtil.getInstance().setData("pwd", pwd, false);
                PreferenceUtil.getInstance().setData("isCick", "1", false);
            } else {
                PreferenceUtil.getInstance().setData("name", "", false);
                PreferenceUtil.getInstance().setData("pwd", "", false);
                PreferenceUtil.getInstance().setData("isCick", "0", false);
            }

            // MainBAOANActivity.start(LoginActivity.this);
            MainTabActivity.start(LoginActivity.this);
            finish();
        }
    }

    //页面绑定方法
    public void loginAuthentication(View view) {
        //收起键盘
        InputMethodManager manager = ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE));
        if (manager != null) {
            manager.hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
        //获取页面数据
        String logName = dataBinding.etUser.getText().toString();
        String passWord = dataBinding.etPassword.getText().toString();

        //调用登录逻辑
        viewModel.loginAuthentication(logName, passWord, Consts.IMEI);
    }

}
