package com.easyloader.zym.library;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Configuration;
import android.util.Log;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zym on 2017/8/16.
 */

public class EasyLoader implements ComponentCallbacks2 {
    private static final String DEFAULT_DISK_CACHE_DIR = "image_manager_disk_cache";
    private static final String TAG = "EasyLoader";
    private static EasyLoader easyLoader;
    private final List<RequestManager> managers = new ArrayList<>();
    private final Context mContext;

    /**
     * @param context
     * @return
     * 初始化缓存文件夹
     */
    public static File getPhotoCacheDir(Context context){
        return getPhotoCacheDir(context, DEFAULT_DISK_CACHE_DIR);
    }

    private static File getPhotoCacheDir(Context context, String cacheName) {
        File cacheDir = context.getCacheDir();
        if (cacheDir != null) {
            File result = new File(cacheDir, cacheName);
            if (!result.mkdirs() && (!result.exists() || !result.isDirectory())) {
                // File wasn't able to create a directory, or the result exists but not a directory
                return null;
            }
            return result;
        }
        if (Log.isLoggable(TAG, Log.ERROR)) {
            Log.e(TAG, "default disk cache dir is null");
        }
        return null;
    }


    public static EasyLoader get(Context context){
        if (easyLoader == null) {
            synchronized (EasyLoader.class) {
                if (easyLoader == null) {
                    easyLoader = initEasyLoader(context);
                }
            }
        }
        return easyLoader;
    }

    private static EasyLoader initEasyLoader(Context context) {
        return EasyLoaderBuilder.build(context);
    }


    EasyLoader(Context context){
        // many init working and registry resource and type
        this.mContext = context;
    }


    public static RequestManager with(Context context) {
        return null;
    }



    @Override
    public void onTrimMemory(int level) {

    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {

    }

    @Override
    public void onLowMemory() {

    }

    void unregisterRequestManager(RequestManager requestManager) {
        synchronized (managers) {
            if (!managers.contains(requestManager)) {
                throw new IllegalStateException("Cannot register not yet registered manager");
            }
            managers.remove(requestManager);
        }
    }

    // requestManager的注册时在Glide中进行
    void registerRequestManager(RequestManager requestManager) {
        synchronized (managers) {
            if (managers.contains(requestManager)) {
                throw new IllegalStateException("Cannot register already registered manager");
            }
            managers.add(requestManager);
        }
    }

    public EasyLoaderContext getGlideContext() {
        return new EasyLoaderContext(mContext,this);
    }
}
