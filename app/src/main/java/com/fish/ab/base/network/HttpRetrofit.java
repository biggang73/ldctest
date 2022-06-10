package com.fish.ab.base.network;


import com.fish.ab.base.Consts;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class HttpRetrofit {
    private static HttpRetrofit httpRetrofit;

    private static HttpRetrofit getInstance() {
        if (httpRetrofit != null) {
            httpRetrofit = new HttpRetrofit();
        }
        return httpRetrofit;
    }

    private Retrofit retrofit;
    private OkHttpClient okHttpClient;

    /**
     * @param httpType 判断是否使用token
     * @return
     */
    public Retrofit getRetrofit(HttpType httpType) {
        if (retrofit == null) {
            HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            builder.addInterceptor(httpLoggingInterceptor);
//            if (httpType == HttpType.HTTP_TOKEN){
            //Token拦截器
            builder.addInterceptor(new TokenInterceptor())
                    .authenticator(new TokenAuthenticator());
//            }

            builder.readTimeout(2, TimeUnit.MINUTES);
            builder.readTimeout(2, TimeUnit.MINUTES);
            okHttpClient = builder.build();

            retrofit = new Retrofit.Builder()
                    .client(okHttpClient)
                    .baseUrl(Consts.BASEURL)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

}
