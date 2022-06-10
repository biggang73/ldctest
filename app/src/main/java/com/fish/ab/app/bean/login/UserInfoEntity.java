package com.fish.ab.app.bean.login;

import android.widget.Toast;
import com.fish.ab.app.network.NetworkListener;
import com.fish.ab.base.Consts;
import com.fish.ab.base.MyApplication;
import com.fish.ab.base.bean.BaseEntity;
import com.fish.ab.base.network.BaseObserver;
import com.fish.ab.base.network.HttpRetrofit;
import com.fish.ab.base.network.HttpType;
import com.fish.ab.base.util.ObjectUtils;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class UserInfoEntity extends BaseEntity {

    private String userID;
    private String projectId;
    private String roleId;
    private String roleType;
    private String roleName;

    public String getRoleType() {
        return roleType;
    }

    public static void login(String logName, final String passWord, final String imei, final NetworkListener listener) {
        new HttpRetrofit().getRetrofit(HttpType.HTTP_TOKEN).create(Consts.class).LoginRequest(logName, passWord, imei)

                .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserver() {
                    @Override
                    public void onNext(BaseEntity be) {
                        //判断接口返回处理
                        if (Consts.RETSUCCESS.equalsIgnoreCase(be.getCode())) { // code = 1 表示成功处理

//                            Toast.makeText(MyApplication.CONTEXT, "登录成功！获取用户信息成功", Toast.LENGTH_LONG).show();

                             if (ObjectUtils.isNotEmpty(((UserInfoEntity) be).getRoleType())) {

                                String roleType = ((UserInfoEntity) be).getRoleType();

                                 if (roleType != null) {
                                     listener.Listener("login", 1, roleType);
                                     Toast.makeText(MyApplication.CONTEXT, "登录成功！获取用户信息成功", Toast.LENGTH_SHORT).show();
                                 } else {
                                    Toast.makeText(MyApplication.CONTEXT, "登录失败，无法获取用户信息", Toast.LENGTH_SHORT).show();
                                }
                            }

                        } else {
                            if ("2".equalsIgnoreCase(be.getCode())){
                                Toast.makeText(MyApplication.CONTEXT, "用户或密码不能为空", Toast.LENGTH_LONG).show();
                            } else if ("3".equalsIgnoreCase(be.getCode())){
                                Toast.makeText(MyApplication.CONTEXT, "用户名不存在", Toast.LENGTH_LONG).show();
                            } else if ("4".equalsIgnoreCase(be.getCode())){
                                Toast.makeText(MyApplication.CONTEXT, "密码错误", Toast.LENGTH_LONG).show();
                            } else if ("0".equalsIgnoreCase(be.getCode())){
                                Toast.makeText(MyApplication.CONTEXT, "登录失败", Toast.LENGTH_LONG).show();
                            } else {
                                Toast.makeText(MyApplication.CONTEXT, "Unexpected Error", Toast.LENGTH_LONG).show();
                            }
                        }
                    }
                });
    }
}