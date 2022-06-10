package com.fish.ab.app.bean;

import android.widget.Toast;

import com.fish.ab.app.network.NetworkListener;
import com.fish.ab.base.Consts;
import com.fish.ab.base.MyApplication;
import com.fish.ab.base.bean.BaseEntity;
import com.fish.ab.base.network.BaseObserver;
import com.fish.ab.base.network.HttpRetrofit;
import com.fish.ab.base.network.HttpType;
import com.fish.ab.base.util.ObjectUtils;


import java.util.ArrayList;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class ProjectInfoEntity extends BaseEntity {
    /*
     * 出来的info gson 包含多个ProjectInfo，所以使用ArrayList<ProjectInfo>
     */
    private ArrayList<ProjectInfo> info;

    private ArrayList<ProjectInfo> getInfo(){
        return info;
    }

    private void setInfo(ArrayList<ProjectInfo> info){
        this.info = info;
    }

    public static void getFsuData(final String type, final String id, final String memberId, final String roleId, final String roleType, final String fsuFlag, final NetworkListener listener) {
        new HttpRetrofit()
                .getRetrofit(HttpType.HTTP_TOKEN)
                .create(Consts.class)
                .GetFsuDataRequest(type, id, memberId,roleId, roleType, fsuFlag)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserver() {

                    @Override
                    public void onNext(BaseEntity be) {

                        //判断接口返回处理
                        if (Consts.RETSUCCESS.equalsIgnoreCase(be.getCode())) { // code = 1 表示成功处理
//                            Toast.makeText(MyApplication.CONTEXT, "获取项目信息成功1", Toast.LENGTH_LONG).show();

                            if (ObjectUtils.isNotEmpty(((ProjectInfoEntity) be).info)) {

//                                Toast.makeText(MyApplication.CONTEXT, "获取项目信息成功2", Toast.LENGTH_LONG).show();
                                ArrayList<ProjectInfo> project_list = ((ProjectInfoEntity) be).info;

                                if (project_list != null) {
                                    listener.Listener("getFsuData", 1, project_list);
                                    Toast.makeText(MyApplication.CONTEXT, "获取项目信息project_list成功", Toast.LENGTH_LONG).show();

                                } else {
                                    Toast.makeText(MyApplication.CONTEXT, "失败，获取项目信息为null", Toast.LENGTH_LONG).show();
                                }
                            }

                        } else {
                            Toast.makeText(MyApplication.CONTEXT, "失败，无法获取项目信息", Toast.LENGTH_LONG).show();
                        }

                    }
                });
    }


}
