package com.fish.ab.base.util;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.widget.Toast;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.PermissionChecker;
import java.util.ArrayList;

import static androidx.core.content.PermissionChecker.checkSelfPermission;

/**
 * Created by cunguoyao on 2017/8/1.
 */

public class PermissionUtils {

    public static int getTargetSdkVersion(Context context) {
        int targetSdkVersion = 0;
        try {
            final PackageInfo info = context.getPackageManager().getPackageInfo(
                    context.getPackageName(), 0);
            targetSdkVersion = info.applicationInfo.targetSdkVersion;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return targetSdkVersion;
    }

    @SuppressLint("WrongConstant")
    public static boolean lacksPermission(Context mContexts, String permission) {

        return checkSelfPermission(mContexts, permission) == PackageManager.PERMISSION_DENIED;

    }

//    public static MyCommonDialog confirmDialog;

    /**
     *
     *      PermissionUtils.check(getActivity(), Manifest.permission.READ_EXTERNAL_STORAGE)
     *                         && PermissionUtils.check(getActivity(), Manifest.permission.WRITE_EXTERNAL_STORAGE)
     *                         && PermissionUtils.check(getActivity(), Manifest.permission.CAMERA)
     */
//    public static boolean check(final Context context, final String permission) {
//        // For Android < Android M, self permissions are always granted.
//        boolean result = true;
//        boolean resultForever;
//
//        if (Build.VERSION.SDK_INT >= 23) {
//            if (getTargetSdkVersion(context) >= 23) {
//                // targetSdkVersion >= Android M, we can
//                // use Context#checkSelfPermission
//                result = checkSelfPermission(context, permission)
//                        == PackageManager.PERMISSION_GRANTED;
//            } else {
//                // targetSdkVersion < Android M, we have to use PermissionChecker
//                result = PermissionChecker.checkSelfPermission(context, permission)
//                        == PermissionChecker.PERMISSION_GRANTED;
//            }
//        }
////        resultForever = ActivityCompat.shouldShowRequestPermissionRationale( (Activity)context, permission);
//        resultForever = lacksPermission(context,permission);
//        if(!result) {//禁止了
//
//            Toast.makeText(context,"操作缺少权限，请授权。", Toast.LENGTH_SHORT).show();
//            if(resultForever) {//请求权限被禁止，但未选择【不再提醒】
//                String permissionNote = "";
//                if (permission.equals(Manifest.permission.READ_EXTERNAL_STORAGE)) {
//                    permissionNote = "当前应用缺少【存储】权限，请点击始终允许。";
//                } else if (permission.equals(Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
//                    permissionNote = "当前应用缺少【读取】权限，请点击始终允许。";
//                } else if (permission.equals(Manifest.permission.CAMERA)) {
//                    permissionNote = "当前应用缺少【相机】权限，请点击始终允许。";
//                } else if (permission.equals(Manifest.permission.RECORD_AUDIO)) {
//                    permissionNote = "当前应用缺少【麦克风】权限，请点击始终允许。";
//                } else if (permission.equals(Manifest.permission.READ_CONTACTS)) {
//                    permissionNote = "当前应用缺少【通讯录】权限，请点击始终允许。";
//                } else if (permission.equals(Manifest.permission.WRITE_CONTACTS)) {
//                    permissionNote = "当前应用缺少【通讯录】权限，请点击始终允许。";
//                }
//                else if (permission.equals(Manifest.permission.READ_PHONE_STATE)) {
//                    permissionNote = "当前应用缺少【设备信息】权限，请点击始终允许。";
//                }
//            }
//            else
//                {//禁止权限，并选中【禁止后不再询问】
//                String permissionNote = "";
//                if (permission.equals(Manifest.permission.READ_EXTERNAL_STORAGE)) {
//                    permissionNote = "当前应用缺少【存储】权限,请进入设置的“应用权限”打开所需权限。";
//                } else if (permission.equals(Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
//                    permissionNote = "当前应用缺少【存储】权限，请进入设置的“应用权限”打开所需权限。";
//                } else if (permission.equals(Manifest.permission.CAMERA)) {
//                    permissionNote = "当前应用缺少【相机】权限，请进入设置的“应用权限”打开所需权限。";
//                } else if (permission.equals(Manifest.permission.RECORD_AUDIO)) {
//                    permissionNote = "当前应用缺少【麦克风】权限，请进入设置的“应用权限”打开所需权限。";
//                }
//                else if (permission.equals(Manifest.permission.READ_CONTACTS)) {
//                    permissionNote = "当前应用缺少【通讯录】权限，请进入设置的“应用权限”打开所需权限。";
//                }
//                else if (permission.equals(Manifest.permission.WRITE_CONTACTS)) {
//                    permissionNote = "当前应用缺少【通讯录】权限，请进入设置的“应用权限”打开所需权限。";
//                }
//                else if (permission.equals(Manifest.permission.READ_PHONE_STATE)) {
//                    permissionNote = "当前应用缺少【设备信息】权限，请进入设置的“应用权限”打开所需权限。";
//                }
//
//            }
//        }
//
//        return result;
//    }

//    /**
//     * 跳转到权限设置界面
//     *
//     * @param context
//     */
//    public static void toPermissionSetting(Context context) throws NoSuchFieldException, IllegalAccessException {
//        if (Build.VERSION.SDK_INT < 23) {
//            if (RomUtils.checkIsMiuiRom()) {
//                MiuiUtils.applyMiuiPermission(context);
//            } else if (RomUtils.checkIsMeizuRom()) {
//                MeizuUtils.applyPermission(context);
//            } else if (RomUtils.checkIsHuaweiRom()) {
//                HuaweiUtils.applyPermission(context);
//            } else if (RomUtils.checkIs360Rom()) {
//                QikuUtils.applyPermission(context);
//            } else if (RomUtils.checkIsOppoRom()) {
//                OppoUtils.applyOppoPermission(context);
//            } else {
//                RomUtils.getAppDetailSettingIntent(context);
//            }
//        } else {
//            if (RomUtils.checkIsMeizuRom()) {
//                MeizuUtils.applyPermission(context);
//            } else {
//                if (RomUtils.checkIsOppoRom() || RomUtils.checkIsVivoRom()
//                        || RomUtils.checkIsHuaweiRom() || RomUtils.checkIsSamsunRom()) {
//                    RomUtils.getAppDetailSettingIntent(context);
//                } else if (RomUtils.checkIsMiuiRom()) {
//                    MiuiUtils.toPermisstionSetting(context);
//                } else {
//                    RomUtils.commonROMPermissionApplyInternal(context);
//                }
//            }
//        }
//    }

    /**
     * android 6.0 以上需要动态申请权限
     *
     * PermissionUtils.requestPermission(getActivity(), new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE
     *                                     , Manifest.permission.CAMERA});
     */

    public static void requestPermission(final Activity activity, final String[] permissions) {

        ArrayList<String> toApplyList = new ArrayList<String>();

        for (String perm : permissions) {
            if (PackageManager.PERMISSION_GRANTED != ContextCompat.checkSelfPermission(activity, perm)) {
                toApplyList.add(perm);
                // 进入到这里代表没有权限.

            }
        }
        String tmpList[] = new String[toApplyList.size()];
        if (!toApplyList.isEmpty()) {
            ActivityCompat.requestPermissions(activity, toApplyList.toArray(tmpList), 123);
        }

    }
}

