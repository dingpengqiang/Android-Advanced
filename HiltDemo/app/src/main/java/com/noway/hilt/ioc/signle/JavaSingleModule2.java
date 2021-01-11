package com.noway.hilt.ioc.signle;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ActivityComponent;
import dagger.hilt.android.components.ApplicationComponent;
import dagger.hilt.android.scopes.ActivityScoped;

/**
 * @author: dpq
 * @date: 2021/1/11
 * @email: dpq@arcvideo.com
 * @version: 2.5.0
 * @desc:
 */

@InstallIn(ActivityComponent.class)
@Module
public class JavaSingleModule2 {

    /**
     * 局部单例：
     * @return
     */
    @ActivityScoped
    @Provides
    public JavaSingle2 getJavaSingle2(){
        return new JavaSingle2();
    }
}
