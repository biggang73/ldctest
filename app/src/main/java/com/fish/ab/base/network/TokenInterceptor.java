package com.fish.ab.base.network;


import com.fish.ab.base.MyApplication;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class TokenInterceptor implements Interceptor {
    private String token = "";

    @NotNull
    @Override
    public Response intercept(@NotNull Interceptor.Chain chain) throws IOException {
        //获取request->网络请求->TOKENKEY判断是否使用token
//        token = PrefeneceUtil.getData("","token",false);

        Request request = chain.request();
        if (request.body() instanceof FormBody) {
            // 构造新的请求表单
            FormBody.Builder builder = new FormBody.Builder();
            FormBody body = (FormBody) request.body();
            //将以前的参数添加
            for (int i = 0; i < body.size(); i++) {
                builder.add(body.encodedName(i), body.encodedValue(i));
            }
            //追加新的参数
            builder.add("accessToken", MyApplication.getInstance().token);
            request = request.newBuilder().post(builder.build()).build();//构造新的请求体
        } else {
            HttpUrl httpUrl = request.url().newBuilder()
                    .addQueryParameter("accessToken", MyApplication.getInstance().token)
                    .build();
            request = request.newBuilder().url(httpUrl).build();
        }

        Request build = request.newBuilder()
                .header("vr_type", "app")
                .build();
        return chain.proceed(build);

    }

}
