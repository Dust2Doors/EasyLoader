package com.easyloader.zym.library;

import java.nio.charset.Charset;
import java.security.MessageDigest;

/**
 * Created by zym on 2017/8/23.
 */

public interface Key {
    String STRING_CHARSET_NAME = "UTF-8";
    Charset CHARSET = Charset.forName(STRING_CHARSET_NAME);

    /**
     * Adds all uniquely identifying information to the given digest.
     *
     * <p> Note - Using {@link java.security.MessageDigest#reset()} inside of this method will result
     * in undefined behavior. </p>
     */
    void updateDiskCacheKey(MessageDigest messageDigest);

    @Override
    boolean equals(Object o);

    @Override
    int hashCode();
}
