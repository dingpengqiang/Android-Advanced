package com.noway.hilt.ioc.interfaces;

import com.noway.hilt.ioc.interfaces.anno.BindChinese;
import com.noway.hilt.ioc.interfaces.anno.BindEnglish;
import com.noway.hilt.ioc.interfaces.anno.BindMath;

import dagger.Binds;
import dagger.Module;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ActivityComponent;

/**
 * @author: dpq
 * @date: 2021/1/11
 * @email: dpq@arcvideo.com
 * @version: 2.5.0
 * @desc:
 */
@InstallIn(ActivityComponent.class)
@Module
public abstract class BookModule {

    /**
     * 多实现 ，需要添加限定符进行区分
     * @param book
     * @return
     */
    @BindChinese
    @Binds
    public abstract IBook bindChinese(ChineseBook book);

    @BindMath
    @Binds
    public abstract IBook bindMath(MathBook book);

    @BindEnglish
    @Binds
    public abstract IBook bindEnglish(EnglishBook book);
}
