package com.noway.myglide;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.noway.lib_glide.Glide;

/**
 * @author: dpq
 * @date: 2020/12/30
 * @email: dpq@arcvideo.com
 * @version: 2.5.0
 * @desc:
 */
public class MainFragment extends Fragment {
    public static final String TAG  = "MainFragment";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.e(TAG, "onCreateView: ");
        Glide.with(this);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

}
