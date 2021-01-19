package com.noway.lib_glide;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * @author: dpq
 * @date: 2020/12/30
 * @email: dpq@arcvideo.com
 * @version: 2.5.0
 * @desc:
 */
public class SupportRequestManagerFragment extends Fragment {

    public static final String TAG = "SupportRequestFragment";

    @Nullable
    private RequestManager requestManager;
    private final ActivityFragmentLifecycle lifecycle;


    public SupportRequestManagerFragment(ActivityFragmentLifecycle lifecycle) {
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
        Log.e(TAG, "onStart: " );
        lifecycle.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.e(TAG, "onStop: ");
        lifecycle.onStop();
    }

    @Override
    public void onDestroy() {
        Log.e(TAG, "onDestroy: ");
        super.onDestroy();
        lifecycle.onDestroy();
    }
}
