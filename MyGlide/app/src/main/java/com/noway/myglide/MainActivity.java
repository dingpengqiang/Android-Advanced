package com.noway.myglide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.noway.lib_glide.Glide;
import com.noway.lib_glide.RequestManager;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        RequestManager with = Glide.with(this);

    }

    public void jump(View view) {
        startActivity(new Intent(this,MainActivity2.class));
        finish();
    }
}