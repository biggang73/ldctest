package com.fish.ab.base;

import android.app.Application;
import android.content.Context;
import android.os.Environment;
import android.os.StrictMode;
import androidx.multidex.MultiDex;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.fish.ab.app.bean.login.UserInfoEntity;
import com.fish.ab.base.util.PreferenceUtil;

public class MyApplication extends Application {

    public static Context CONTEXT;
    public static String registrationId;
    public static final String WORKSPACE = "/qdciz/workspace";
    public static final String IMAGE = "image/";
    public static final String UPLOAD_IMAGE_FILE = "uploadimage/";
    public static final String SDPATH = Environment
            .getExternalStorageDirectory().toString();
    public static final String BASEPATH = SDPATH + "/EDU";
    public static final String CACHEFILE = BASEPATH + "/cachefile";
    public static final String HEADIMAGEFILE = CACHEFILE + "/headimagefile";
    public static final String PATH_CLASS_MEMBER = "member/";//班级成员下载列表

    private static MyApplication mInstance;

    public static UserInfoEntity userInfoEntity;

    public static synchronized MyApplication getInstance() {
        return mInstance;
    }

    public static String token = "";

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;

        CONTEXT = this;
        MultiDex.install(this);
        SDKInitializer.initialize(this);
        SDKInitializer.setCoordType(CoordType.BD09LL);
//        MobclickAgent.setPageCollectionMode(MobclickAgent.PageMode.AUTO);
        PreferenceUtil.getInstance().initPreference(this);

        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());
        if (android.os.Build.VERSION.SDK_INT >= 18) {
            builder.detectFileUriExposure();
        }
    }

}
