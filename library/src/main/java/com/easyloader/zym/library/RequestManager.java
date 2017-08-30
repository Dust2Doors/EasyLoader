package com.easyloader.zym.library;

import android.content.Context;

/**
 * Created by zym on 2017/8/16.
 */

public class RequestManager implements LifecycleListener{


    private EasyLoader easyLoader;
    private Lifecycle lifecycle;
    RequestManager(
            EasyLoader easyLoader,
            Lifecycle lifecycle
//            RequestManagerTreeNode treeNode,
//            RequestTracker requestTracker,
//            ConnectivityMonitorFactory factory) {
    ){
        this.easyLoader = easyLoader;
        this.lifecycle = lifecycle;
//        this.treeNode = treeNode;
//        this.requestTracker = requestTracker;

        final Context context = easyLoader.getGlideContext().getBaseContext();
//
//        connectivityMonitor =
//                factory.build(context, new RequestManagerConnectivityListener(requestTracker));

        // If we're the application level request manager, we may be created on a background thread.
        // In that case we cannot risk synchronously pausing or resuming requests, so we hack around the
        // issue by delaying adding ourselves as a lifecycle listener by posting to the main thread.
        // This should be entirely safe.
//        if (Util.isOnBackgroundThread()) {
//            mainHandler.post(addSelfToLifecycle);
//        } else {
//            lifecycle.addListener(this);
//        }
//        lifecycle.addListener(connectivityMonitor);
//
//        setRequestOptions(glide.getGlideContext().getDefaultRequestOptions());

        easyLoader.registerRequestManager(this);
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void onDestroy() {
//        targetTracker.onDestroy();
//        for (Target<?> target : targetTracker.getAll()) {
//            clear(target);
//        }
//        targetTracker.clear();
//        requestTracker.clearRequests();
//        lifecycle.removeListener(this);
//        lifecycle.removeListener(connectivityMonitor);
//        mainHandler.removeCallbacks(addSelfToLifecycle);
        easyLoader.unregisterRequestManager(this);
    }
    //接口注册从此终止
    public void onTrimMemory(int level) {
        easyLoader.getGlideContext().onTrimMemory(level);
    }

    public void onLowMemory() {
        easyLoader.getGlideContext().onLowMemory();
    }

}
