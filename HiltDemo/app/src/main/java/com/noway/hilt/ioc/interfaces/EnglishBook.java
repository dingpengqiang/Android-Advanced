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
public class EnglishBook implements IBook {

    @Inject
    public EnglishBook() {
    }

    @Override
    public void showBook() {
        Log.d("Noway", "英语书: "+ this.hashCode());
    }
}
