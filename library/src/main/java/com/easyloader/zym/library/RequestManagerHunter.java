package com.easyloader.zym.library;

import android.app.FragmentManager;
import android.os.Handler;
import android.os.Message;

import java.util.Map;

/**
 *  a collection of static method  to create new{@link RequestManager} or get an exist one
 *  from activity or fragment
 */

public class RequestManagerHunter implements Handler.Callback {

    private final String FRAGMENT_TAG = "com.bumptech.glide.manager";
    private static final String TAG = "RequestManagerHunter";

    private static final int ID_REMOVE_FRAGMENT_MANAGER = 1;
    private static final int ID_REMOVE_SUPPORT_FRAGMENT_MANAGER = 2;

    private static final String FRAGMENT_INDEX_KEY = "key";
    private static final String FRAGMENT_MANAGER_GET_FRAGMENT_KEY = "i";


    private volatile RequestManager requestManager;

    /**
     *   pending adds for requestManagerFragments
     *   first we should get a requestManagerFragment
     * @param msg
     * @return
     */



    @Override
    public boolean handleMessage(Message msg) {
        return false;
    }

    public interface RequestManagerFactory{
        RequestManager build(EasyLoader easyLoader, Lifecycle lifecycle);
    }

}
