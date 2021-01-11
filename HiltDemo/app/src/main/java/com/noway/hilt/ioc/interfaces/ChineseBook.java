package com.noway.hilt.ioc.interfaces;

import android.util.Log;
import android.widget.Toast;

import javax.inject.Inject;

/**
 * @author: dpq
 * @date: 2021/1/11
 * @email: dpq@arcvideo.com
 * @version: 2.5.0
 * @desc:
 */
public class ChineseBook implements IBook {

    /**
     * 接口通过实现类的构造方法注入
     */
    @Inject
    public ChineseBook() {
    }

    @Override
    public void showBook() {
        Log.d("Noway", "语文书: "+ this.hashCode());
    }
}
