package com.easyloader.zym.library;

/**
 * Created by zym on 2017/8/23.
 */

public interface Resource<Z> {

    /**
     *  return the wrapper resource class
     */
    Class<Z> getResourceClass();

    Z get();

    int getSize();

    void recycle();
}
