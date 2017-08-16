package com.easyloader.zym.library;

import android.os.Handler;
import android.os.Message;

/**
 * Created by zym on 2017/8/16.
 */

public class RequestManagerHunter implements Handler.Callback {

    @Override
    public boolean handleMessage(Message msg) {
        return false;
    }

    public interface RequestManagerFactory{
        RequestManager build(EasyLoader easyLoader, Lifecycle lifecycle);
    }

}
