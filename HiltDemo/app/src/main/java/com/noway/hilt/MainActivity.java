package com.noway.hilt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.noway.hilt.ioc.bean.JavaBean;
import com.noway.hilt.ioc.interfaces.ChineseBook;
import com.noway.hilt.ioc.interfaces.IBook;
import com.noway.hilt.ioc.interfaces.anno.BindChinese;
import com.noway.hilt.ioc.interfaces.anno.BindEnglish;
import com.noway.hilt.ioc.interfaces.anno.BindMath;
import com.noway.hilt.ioc.module.JavaObject;
import com.noway.hilt.ioc.signle.JavaSingle;
import com.noway.hilt.ioc.signle.JavaSingle2;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {

    @Inject
    JavaBean mJavaBean;

    @Inject
    JavaObject mJavaObject;


    @Inject
    JavaSingle mJavaSingle;

    @Inject
    JavaSingle mJavaSingle2;


    @Inject
    JavaSingle2 mJavaSingle3;

    @Inject
    JavaSingle2 mJavaSingle4;

    @BindChinese
    @Inject
    IBook mIBook;

    @BindMath
    @Inject
    IBook mIBook1;

    @BindEnglish
    @Inject
    IBook mIBook2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn:
                mJavaBean.showMessage(this);
                break;
            case R.id.btn2:
                 mJavaObject.showMessage(this);
                break;

            case R.id.btn3:
                mJavaSingle3.showMessage(this);
                mJavaSingle4.showMessage(this);

                startActivity(new Intent(this,SecActivity.class));
                break;
            case R.id.btn4:
                mJavaSingle.showMessage(this);
                mJavaSingle2.showMessage(this);

                startActivity(new Intent(this,SecActivity.class));

                break;
            case R.id.btn5:
                mIBook.showBook();
                break;
            case R.id.btn6:
                mIBook1.showBook();
                break;
            case R.id.btn7:
                mIBook2.showBook();
                break;
            default:
                break;
        }
    }
}