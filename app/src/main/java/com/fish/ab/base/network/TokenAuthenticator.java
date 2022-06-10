package com.fish.ab.base.network;


import android.content.Intent;
import android.util.Log;


import com.fish.ab.app.view.LoginActivity;
import com.fish.ab.base.MyApplication;
import com.fish.ab.base.util.ActivityControl;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;

import okhttp3.Authenticator;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;

public class TokenAuthenticator implements Authenticator {

    @Nullable
    @Override
    public Request authenticate(@Nullable Route route, @NotNull Response response) throws IOException {
        int code = response.code();
        Log.i("MLQ", "authenticate: " + code);
        if (code == 401) {
            //TODO Token过期
            Intent intent = new Intent(MyApplication.CONTEXT, LoginActivity.class);
            MyApplication.CONTEXT.startActivity(intent);
            ActivityControl.getInstance().closeAll();
        }
        if (code != 200) {
//            Toast.makeText( MyApplication.CONTEXT,)
        }
        return response.request();
    }
}
