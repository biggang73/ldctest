package com.fish.ab.app.view;

import android.os.Handler;
import android.util.Log;

import com.fish.ab.R;
import com.fish.ab.base.util.ActivityControl;
import com.fish.ab.base.util.AesUtils;
import com.fish.ab.base.vm.BaseNoModelActivity;
import com.fish.ab.databinding.ActivitySplashBinding;


public class SplashActivity extends BaseNoModelActivity<ActivitySplashBinding> {


    @Override
    protected int onCreate() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initView() {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
//                Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
//                startActivity(intent);

                String str = "Hello123@#￥%……！";
                try {
                    str = AesUtils.encrypt(str);
                    Log.e("AesUtils.encrypt", str);
                    str = AesUtils.decrypt(str);
                    Log.e("AesUtils.decrypt", str);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

//                RegisterActivity.start(SplashActivity.this, true);
//                LoginActivity.start(SplashActivity.this, true);

                MainActivity.start(SplashActivity.this, true);
                ActivityControl.getInstance().close(SplashActivity.this);
            }
        }, 2000);
    }

    @Override
    protected void initData() {

    }
}
