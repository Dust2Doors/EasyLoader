package com.easyloader.zym.library.engine;

import android.support.annotation.Nullable;

import com.easyloader.zym.library.Key;
import com.easyloader.zym.library.cache.MemoryCache;
import com.easyloader.zym.library.util.LruCache;

/**
 * 缓存核心类 实现顶级父类的借口 并且继承自HashMap的封装类LruCache
 */

public class LruResourceCache extends LruCache<Key,Resource<?>> implements MemoryCache {
    @Override
    public int getCurrentSize() {
        return 0;
    }

    @Override
    public void setSizeMulitiplier(float mulitiplier) {

    }

    @Nullable
    @Override
    public Resource<?> remove(Key key) {
        return null;
    }

    @Override
    public Resource<?> put(Key key, Resource<?> resource) {
        return null;
    }

    @Override
    public void setResourceRemovedListener(ResourceRemovedListener listener) {

    }

    @Override
    public void clearMemory() {

    }

    @Override
    public void trimMemoroy(int level) {

    }
}
