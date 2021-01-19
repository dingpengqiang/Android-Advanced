package com.noway.livedatabus;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.noway.livedatabus.databinding.ActivityLiveBusBinding;
import com.noway.livedatabus.databinding.ActivityLiveBusXBinding;

public class LiveBusXActivity extends AppCompatActivity {

    private ActivityLiveBusXBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_bus_x);

        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_live_bus_x);

        initEvent();
        initData();
        /**
         * 等待消息发送完之后，再订阅还能收到以前的消息
         */
        mBinding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LiveBusXActivity.this, Sec2Activity.class);
                startActivity(intent);
            }
        });
    }

    private void initData() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    LiveDataBus.getInstance().with("NowayX", String.class).postValue("我是LiveBusX:"+i);
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
        LiveDataBus.getInstance().with("NowayX", String.class)
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