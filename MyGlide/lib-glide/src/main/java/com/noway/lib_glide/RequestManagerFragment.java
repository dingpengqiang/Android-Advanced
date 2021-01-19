package com.noway.lib_glide;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * @author: dpq
 * @date: 2020/12/30
 * @email: dpq@arcvideo.com
 * @version: 2.5.0
 * @desc:
 */
@SuppressLint("ValidFragment")
public class RequestManagerFragment extends Fragment {

    public static final String TAG = "RequestManagerFragment";
    @Nullable
    private RequestManager requestManager;
    private final ActivityFragmentLifecycle lifecycle;

    public RequestManagerFragment(ActivityFragmentLifecycle lifecycle) {
        this.lifecycle = lifecycle;
    }

    @Nullable
    public RequestManager getRequestManager() {
        return requestManager;
    }

    public void setRequestManager(@Nullable RequestManager requestManager) {
        this.requestManager = requestManager;
    }


    @NonNull
    public ActivityFragmentLifecycle getGlideLifecycle() {
        return lifecycle;
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.e(TAG, "onStart: ");
        lifecycle.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.e(TAG, "onStop: " );
        lifecycle.onStop();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy: " );
        lifecycle.onDestroy();
    }
}
