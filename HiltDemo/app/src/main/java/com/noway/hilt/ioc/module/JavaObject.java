package com.noway.hilt.ioc.module;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;


public class JavaObject {


    public void showMessage(Context context){
        Log.d("Noway", ": "+ this.hashCode());
        Toast.makeText(context, "对象的hashcode = " + this.hashCode(), Toast.LENGTH_SHORT).show();
    }
}
