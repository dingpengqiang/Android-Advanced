package com.noway.hilt.ioc.interfaces;

import android.util.Log;

import javax.inject.Inject;

/**
 * @author: dpq
 * @date: 2021/1/11
 * @email: dpq@arcvideo.com
 * @version: 2.5.0
 * @desc:
 */
public class MathBook implements IBook {

    @Inject
    public MathBook() {
    }
    @Override
    public void showBook() {
        Log.d("Noway", "数学书: "+ this.hashCode());
    }
}
