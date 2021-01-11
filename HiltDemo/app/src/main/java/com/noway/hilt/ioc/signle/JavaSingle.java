package com.noway.hilt.ioc.signle;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;


public class JavaSingle {


    public void showMessage(Context context){
        Log.d("Noway", "全局单例: "+ this.hashCode());
//        Toast.makeText(context, "对象的hashcode = " + this.hashCode(), Toast.LENGTH_SHORT).show();
    }
}
