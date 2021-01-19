package com.noway.livedata;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.noway.livedata.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {


    private NameViewModel mViewModel;
    private ActivityMainBinding mDataBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);


        //该方法已过期
//        mViewModel = ViewModelProviders.of(this).get(NameViewModel.class);
        //最新方法
        mViewModel = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory())
                .get(NameViewModel.class);

        initObserver();
        initData();
    }

    private void initData() {
        mDataBinding.button.setOnClickListener(v ->
                //setValue 主线程更新UI
                mViewModel.getCurrentName().setValue(Thread.currentThread().getName()+":Hello Noway")
        );

        mDataBinding.button2.setOnClickListener(v->{
            new Thread(new Runnable() {
                @Override
                public void run() {
                    //postValue 子线程更新UI
                    mViewModel.getCurrentName().postValue(Thread.currentThread().getName()+":Hello Noway");
                }
            }).start();
        });

    }

    private void initObserver() {
        //订阅观察者观察数据的变化
        mViewModel.getCurrentName().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                mDataBinding.textView.setText(s);
            }
        });
    }
}