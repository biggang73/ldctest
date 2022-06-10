package com.fish.ab.app.vm;

import com.fish.ab.app.bean.ProjectInfo;
import com.fish.ab.app.bean.ProjectInfoEntity;
import com.fish.ab.app.network.NetworkListener;
import com.fish.ab.base.vm.BaseViewModel;

public class FsuDetailViewModel extends BaseViewModel {

    /*
      获取Fsu信息
       */
    public void getFsuData(String type, String id, String memberId, String roleId, String roleType, String fsuFlag) {
        //调用接口
        ProjectInfoEntity.getFsuData(type, id, memberId, roleId, roleType, fsuFlag, clickListener);
    }


    public NetworkListener clickListener = new NetworkListener() {
        @Override
        public void Listener(String type, int code, Object obj) {
            if ("getFsuData".equalsIgnoreCase(type)) {
                if (code == 1) {
                    if (error != null)
                        error.setValue(obj);
                }
            }
        }
    };


}
