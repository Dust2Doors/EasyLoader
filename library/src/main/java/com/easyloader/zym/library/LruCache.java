package com.easyloader.zym.library;

import android.support.annotation.Nullable;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 *  lrucache
 */

public class LruCache<T,K> {
    private LinkedHashMap<T, K> cache = new LinkedHashMap<>(100, 0.7f, true);
    private final int initialMaxSize;
    private int maxSize;
    private int currentSize = 0;

    public LruCache(int size) {
        this.initialMaxSize = size;
        this.maxSize = size;
    }

    public synchronized void setSizeMultiplier(float multiplier) {
        if (multiplier < 0) {
            throw new IllegalArgumentException(" Multiplier must be > = 0");
        }
        maxSize = Math.round(initialMaxSize * multiplier);
        evict();
    }

    private void evict() {

            trimToSize(maxSize);
    }

    private void trimToSize(int maxSize) {
        Map.Entry<T,K> last; // 最后一对缓存对象
        while (currentSize > maxSize) {
            last = cache.entrySet().iterator().next();
            final K toBeRemoved = last.getValue();
            currentSize -= getSize(toBeRemoved);
            final T key = last.getKey();
            cache.remove(key);
            onItemEvicted(key, toBeRemoved);
        }
    }


    public synchronized K put(T key, K item) {
        final int itemSize = getSize(item);
        if (itemSize >= maxSize) {
            onItemEvicted(key, item);
            return null;
        }

        final K result = cache.put(key, item);
        if (item != null) {
            currentSize += getSize(item);
        }
        if (result != null) {
            // TODO: should we call onItemEvicted here?
            currentSize -= getSize(result);
        }
        evict();

        return result;
    }

    /**
     * Removes the item at the given key and returns the removed item if present, and null otherwise.
     *
     * @param key The key to remove the item at.
     */
    @Nullable
    public synchronized K remove(T key) {
        final K value = cache.remove(key);
        if (value != null) {
            currentSize -= getSize(value);
        }
        return value;
    }
    /**
     *  缓存对象被移除的回掉
     * @param key
     * @param toBeRemoved
     */
    protected void onItemEvicted(T key, K toBeRemoved) {

    }

    protected int getSize(K toBeRemoved) {
        return 1;
    }
}
