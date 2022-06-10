package com.fish.ab.app.vm;

import com.fish.ab.app.network.NetworkListener;
import com.fish.ab.base.vm.BaseViewModel;

public class MainBAOANViewModel extends BaseViewModel {
    public NetworkListener clickListener = new NetworkListener() {
        @Override
        public void Listener(String type, int code, Object obj) {
            if ("login".equalsIgnoreCase(type)) {
                if (code == 1) {
                    if (error != null)
                        error.setValue("main");
                }
            }
        }
    };
}