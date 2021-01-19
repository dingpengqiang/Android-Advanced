package com.noway.lib_glide;

import androidx.annotation.NonNull;

/**
 * @author: dpq
 * @date: 2020/12/30
 * @email: dpq@arcvideo.com
 * @version: 2.5.0
 * @desc:
 */
public interface Lifecycle {
    void addListener(@NonNull LifecycleListener listener);

    void removeListener(@NonNull LifecycleListener listener);
}

