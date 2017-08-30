package com.easyloader.zym.library;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Configuration;

/**
 *  context for all loads  in easyloader
 */
public class EasyLoaderContext extends ContextWrapper implements ComponentCallbacks2{

    private ComponentCallbacks2 componentCallbacks2;
    public EasyLoaderContext(Context context,ComponentCallbacks2 componentCallbacks){
            super(context.getApplicationContext());
            this.componentCallbacks2 = componentCallbacks;
    }

    @Override
    public void onTrimMemory(int level) {

    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {

    }

    @Override
    public void onLowMemory() {
        componentCallbacks2.onLowMemory();
    }
}
