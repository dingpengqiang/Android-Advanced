package com.noway.lib_glide;

import android.content.Context;
import android.util.Log;

/**
 * @author: dpq
 * @date: 2020/12/30
 * @email: dpq@arcvideo.com
 * @version: 2.5.0
 * @desc:
 */
public class RequestManager implements LifecycleListener {
    public static final String TAG = "RequestManager";
    public RequestManager(Glide glide, Lifecycle lifecycle, Context context) {
        lifecycle.addListener(this);
    }


    @Override
    public void onStart() {
        Log.e(TAG, "onStart: " );
    }

    @Override
    public void onStop() {
        Log.e(TAG, "onStop: ");
    }

    @Override
    public void onDestroy() {
        Log.e(TAG, "onDestroy: ");
    }
}
