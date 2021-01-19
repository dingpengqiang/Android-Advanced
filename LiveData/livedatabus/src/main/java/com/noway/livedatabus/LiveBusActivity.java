package com.noway.livedatabus;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.noway.livedatabus.databinding.ActivityLiveBusBinding;
import com.noway.livedatabus.databinding.ActivityMainBinding;

public class LiveBusActivity extends AppCompatActivity {

    private ActivityLiveBusBinding mBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_live_bus);

        initEvent();
        initData();
        /**
         * 等待消息发送完之后，再订阅还能收到以前的消息
         */
        mBinding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LiveBusActivity.this, SecActivity.class);
                startActivity(intent);
            }
        });

    }

    private void initData() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    LiveDataBus.getInstance().with("Noway", String.class).postValue("我是LiveBus:"+i);
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }).start();
    }

    private void initEvent() {
        LiveDataBus.getInstance().with("Noway", String.class)
                .observe(this, new Observer<String>() {
                    @Override
                    public void onChanged(String s) {
                        if (s != null) {
                            mBinding.textView.setText(s);
                        }
                    }
                });
    }
}