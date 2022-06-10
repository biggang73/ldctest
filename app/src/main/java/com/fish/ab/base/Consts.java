package com.fish.ab.base;


import com.fish.ab.app.bean.ProjectInfoEntity;
import com.fish.ab.app.bean.login.UserInfoEntity;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface Consts {

    public static Boolean isNoSericer = false;
    String RETSUCCESS = "1";
    int PAGESIZE = 20;

    String IMEI = "1298bbd8273233ff";

    // http://218.94.21.35:8877/S3Program/data/login_checkLoginByPhone.action?logName=admin&passWord=S3Web123&imei=1298bbd8273233ff
    String BASEIP_Yaao = "http://218.94.21.35:8877";
    String BASEURL = BASEIP_Yaao + "";


    @FormUrlEncoded
    @POST("/S3Program/data/login_checkLoginByPhone.action")
    Observable<UserInfoEntity> LoginRequest(@Field("logName") String logName,
                                            @Field("passWord") String passWord,
                                            @Field("imei") String imei);

    @FormUrlEncoded
    @POST("/S3Program/data/fsu_getFSUTreeById.do")
    Observable<ProjectInfoEntity> GetFsuDataRequest(@Field("type") String type,
                                                     @Field("id") String id,
                                                     @Field("memberId") String memberId,
                                                     @Field("roleId") String roleId,
                                                     @Field("roleType") String roleType,
                                                     @Field("fsuFlag") String fsuFlag);
}