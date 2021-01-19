package com.noway.livedatabus;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import android.os.Bundle;
import android.widget.Toast;

public class SecActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sec);
        initEvent();
    }


    private void initEvent() {
        LiveDataBus.getInstance().with("Noway", String.class)
                .observe(this, new Observer<String>() {
                    @Override
                    public void onChanged(String s) {
                        if (s != null) {
                            Toast.makeText(SecActivity.this,s,Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}