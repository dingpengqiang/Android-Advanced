package com.noway.livedatabus;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.noway.livedatabus.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);


        mBinding.button.setOnClickListener(v -> {
            startActivity(new Intent(this,LiveBusActivity.class));
        });
        mBinding.button1.setOnClickListener(v -> {
            startActivity(new Intent(this,LiveBusXActivity.class));
        });
    }


}