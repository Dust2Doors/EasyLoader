package com.easyloader.zym.library.cache;

import android.support.annotation.Nullable;

import com.easyloader.zym.library.Key;
import com.easyloader.zym.library.engine.Resource;

/**
 * 缓存管理类 顶级父类
 */

public interface MemoryCache {

    interface ResourceRemovedListener{
        void onResourceReomoved(Resource<?> removed);
    }

    int getCurrentSize();

    void setSizeMulitiplier(float mulitiplier);

    @Nullable
    Resource<?> remove(Key key);

    Resource<?> put(Key key, Resource<?> resource);

    void setResourceRemovedListener(ResourceRemovedListener listener);

    void clearMemory();

    void trimMemoroy(int level);
}
