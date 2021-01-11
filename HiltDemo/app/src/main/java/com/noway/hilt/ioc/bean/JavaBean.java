package com.noway.hilt.ioc.bean;

import android.content.Context;
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
public class JavaBean {

    /**
     * 构造方法注入
     */
    @Inject
    public JavaBean() {
    }


    public void showMessage(Context context){
        Log.d("Noway", ": "+ this.hashCode());
        Toast.makeText(context, "对象的hashcode = " + this.hashCode(), Toast.LENGTH_SHORT).show();
    }

}
