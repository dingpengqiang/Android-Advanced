package com.noway.livedatabus;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import android.os.Bundle;
import android.widget.Toast;

public class Sec2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sec2);
        initEvent();
    }


    private void initEvent() {

        LiveDataBusX.getInstance().with("NowayX",String.class)
                .observe(this, new Observer<String>() {
                    @Override
                    public void onChanged(String s) {
                        if (s != null) {
                            Toast.makeText(Sec2Activity.this,s,Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}