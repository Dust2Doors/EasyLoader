package com.easyloader.zym.library;

import android.content.Context;

/**
 * Created by zym on 2017/8/16.
 */

public class EasyLoaderBuilder {

    public static EasyLoader build(Context context){
        return new EasyLoader(context);
    }

}
