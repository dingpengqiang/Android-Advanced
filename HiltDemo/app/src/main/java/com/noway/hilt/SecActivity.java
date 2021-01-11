package com.noway.hilt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.noway.hilt.ioc.signle.JavaSingle;
import com.noway.hilt.ioc.signle.JavaSingle2;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class SecActivity extends AppCompatActivity {


    @Inject
    JavaSingle mJavaSingle;

    @Inject
    JavaSingle2 mJavaSingle2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sec);


        mJavaSingle.showMessage(this);
        mJavaSingle2.showMessage(this);
    }
}