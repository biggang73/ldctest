package com.fish.ab.app.view;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import androidx.lifecycle.ViewModelProvider;

import com.blankj.utilcode.util.ToastUtils;
import com.fish.ab.R;
import com.fish.ab.app.vm.BaseTitleViewModel;
import com.fish.ab.app.vm.MainBAOANViewModel;
//import com.fish.ab.base.util.PermissionUtils;
import com.fish.ab.base.vm.BaseActivity;
import com.fish.ab.databinding.ActivityHomeBaoanBinding;

import zhangphil.iosdialog.widget.ActionSheetDialog;


public class MainBAOANActivity extends BaseActivity<MainBAOANViewModel, ActivityHomeBaoanBinding> {


    private String TAG = "MainBAOANActivity";

//    private LoginViewBean bean;

    public static void start(Context context) {
        Intent intent = new Intent(context, MainBAOANActivity.class);
        context.startActivity(intent);

    }

    @Override
    protected int onCreate() {
        return R.layout.activity_home_baoan;
    }

    @Override
    protected void initView() {
    }

    @Override
    protected void initData() {
        dataBinding.setModel(this);

        dataBinding.setTitlevm(titleViewModel);
        setTitle("首页");
        showBack(false);
        showMenu(true);
    }

    @Override
    protected void getBack(Object obj) {
        finish();
    }

    @Override
    protected void getMenu(Object obj) {

        new ActionSheetDialog(MainBAOANActivity.this)
                .builder()
                .setCancelable(true)
                .setCanceledOnTouchOutside(true)
                .addSheetItem("身份验证",
                        ActionSheetDialog.SheetItemColor.Blue,
                        new ActionSheetDialog.OnSheetItemClickListener() {
                            @Override
                            public void onClick(int which) {
                                //填写事件

//                                if(PermissionUtils.check(MainBAOANActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE)
//                                        && PermissionUtils.check(MainBAOANActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
//                                        && PermissionUtils.check(MainBAOANActivity.this, Manifest.permission.CAMERA)
//                                        && PermissionUtils.check(MainBAOANActivity.this, Manifest.permission.RECORD_AUDIO)) {
////                                    SendPersonActivity.start(MainBAOANActivity.this,true);
//                                }else{
//                                    PermissionUtils.requestPermission((Activity) MainBAOANActivity.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE
//                                            , Manifest.permission.CAMERA, Manifest.permission.RECORD_AUDIO});
//
//                                }
                            }
                        })
                .addSheetItem("登出",
                        ActionSheetDialog.SheetItemColor.Blue,
                        new ActionSheetDialog.OnSheetItemClickListener() {
                            @Override
                            public void onClick(int which) {
                                //填写事件
                                LoginActivity.start(MainBAOANActivity.this, false);
                                finish();
                            }
                        })
                .show();

    }


    @Override
    protected MainBAOANViewModel initViewModel() {

        return new ViewModelProvider(this).get(MainBAOANViewModel.class);
    }

    @Override
    protected BaseTitleViewModel initTitleVM() {
        return new ViewModelProvider(this).get(BaseTitleViewModel.class);
    }

    @Override
    protected void showError(Object obj) {
        if (obj.equals("main")) {
            finish();
        }
    }

    //在岗管理
    public void singloc(View view) {
//        if (PermissionUtils.check(MainBAOANActivity.this, Manifest.permission.ACCESS_COARSE_LOCATION)
//                && PermissionUtils.check(MainBAOANActivity.this, Manifest.permission.ACCESS_FINE_LOCATION)
//                && PermissionUtils.check(MainBAOANActivity.this, Manifest.permission.ACCESS_WIFI_STATE)
//                && PermissionUtils.check(MainBAOANActivity.this, Manifest.permission.ACCESS_NETWORK_STATE)
//                && PermissionUtils.check(MainBAOANActivity.this, Manifest.permission.CHANGE_WIFI_STATE)) {
////            CheckClockActivity.start(this);
//        } else {
//            PermissionUtils.requestPermission((Activity) MainBAOANActivity.this, new String[]{
//                    Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION
//                    , Manifest.permission.ACCESS_WIFI_STATE, Manifest.permission.ACCESS_NETWORK_STATE
//                    , Manifest.permission.CHANGE_WIFI_STATE});
//
//        }


    }


    //重点巡查
    public void nfc(View view) {

//        if (PermissionUtils.check(MainBAOANActivity.this, Manifest.permission.NFC)
//        ) {
////            NFCActivity.start(this);
//        } else {
//            PermissionUtils.requestPermission((Activity) MainBAOANActivity.this, new String[]{
//                    Manifest.permission.NFC});
//
//        }


    }

    //岗位职责
    public void gwzz(View view) {

//        JobResponListActivity.start(this);
    }

    //履职档案
    public void lzda(View view) {

//        if (PermissionUtils.check(MainBAOANActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE)
//                && PermissionUtils.check(MainBAOANActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
//                && PermissionUtils.check(MainBAOANActivity.this, Manifest.permission.CAMERA)) {
////            AddJobResponActivity.start(this);
//        } else {
//            PermissionUtils.requestPermission((Activity) MainBAOANActivity.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE
//                    , Manifest.permission.CAMERA});
//
//        }


    }

    //聊天
    public void chat(View view) {
//        ChatListActivity.start(this);
    }


    private long mExitTime;

    @Override //再按一次退出程序
    public void onBackPressed() {
        if (System.currentTimeMillis() - mExitTime < 2000) {
            super.onBackPressed();
        } else {
            mExitTime = System.currentTimeMillis();
            ToastUtils.showShort("再按一次返回键退出应用");
        }
    }


}
