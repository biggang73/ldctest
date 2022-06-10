package com.fish.ab.app.vm;

import com.blankj.utilcode.util.ToastUtils;
import com.fish.ab.app.bean.login.UserInfoEntity;
import com.fish.ab.app.network.NetworkListener;
import com.fish.ab.base.util.ObjectUtils;
import com.fish.ab.base.vm.BaseViewModel;

public class LoginViewModel extends BaseViewModel {

    /*
     * 验证数据
     */
    public void loginAuthentication(String logName, String passWord, String imei) {
        if (ObjectUtils.isEmpty(logName)) {
            ToastUtils.showShort("用户名不能为空");
            return;

        }
        if (ObjectUtils.isEmpty(passWord)) {
            ToastUtils.showShort("密码不能为空");
            return;
        }
        //调用
        UserInfoEntity.login(logName, passWord, imei, clickListener);
    }


    public NetworkListener clickListener = new NetworkListener() {
        @Override
        public void Listener(String type, int code, Object obj) {
            if ("login".equalsIgnoreCase(type)) {
                if (code == 1) {
                    if (error != null)
                        error.setValue(obj);
                }
            }
        }

    };

}
