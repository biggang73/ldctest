package com.fish.ab.base.util;

import android.content.Context;
import android.content.SharedPreferences;

/*
 * 使用方法
 * 1.先在application 初始化
 * 2.其他地方直接使用
 */
public class PreferenceUtil {
    private static SharedPreferences sp;
    private static SharedPreferences.Editor editor;
    private static String privateName = "privateName";
    protected static String aeskey = "1234567890123456";

    private static PreferenceUtil preferenceUtil;

    public static PreferenceUtil getInstance() {
        if (preferenceUtil == null) {
            preferenceUtil = new PreferenceUtil();
        }
        return preferenceUtil;
    }

    public PreferenceUtil() {

    }


    public static String getString(Context context, String key) {
        SharedPreferences sp = context.getSharedPreferences(privateName,
                Context.MODE_PRIVATE);
        return sp.getString(key, "");
    }


    public static void initPreference(Context context) {
        sp = context.getSharedPreferences(privateName,
                Context.MODE_PRIVATE);
        editor = sp.edit();
    }

    public static void setData(String key, String sign, Boolean encry) {
        AesUtils.getInstance(aeskey);
        try {
            if (encry) {
                key = AesUtils.encrypt(key);
                sign = AesUtils.encrypt(sign);
            }
            editor.putString(key, sign);
            editor.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static String getData(String key, String defaultStr, Boolean encry) {
        AesUtils.getInstance(aeskey);
        String data = "";
        try {
            if (encry) {
                key = AesUtils.encrypt(key);
            }
            data = sp.getString(key, defaultStr);
            if (encry) {
                data = AesUtils.decrypt(data);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return data;
    }

}