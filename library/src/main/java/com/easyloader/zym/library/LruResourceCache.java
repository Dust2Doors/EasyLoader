package com.easyloader.zym.library;

import com.easyloader.zym.library.load.engine.cache.MemoryCache;

/**
 * 缓存核心类 实现顶级父类的借口 并且继承自HashMap的封装类LruCache
 */

public class LruResourceCache extends LruCache<Key,Resource<?>> implements MemoryCache {

    public LruResourceCache(int size) {
        super(size);
    }

    @Override
    public int getCurrentSize() {
        return 0;
    }

    @Override
    public void setSizeMulitiplier(float mulitiplier) {

    }

    @Override
    public void setResourceRemovedListener(ResourceRemovedListener listener) {
    }

    @Override
    public void clearMemory() {

    }

    @Override
    public void trimMemory(int level) {

    }
}
