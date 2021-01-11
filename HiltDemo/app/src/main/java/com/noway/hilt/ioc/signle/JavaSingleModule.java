package com.noway.hilt.ioc.signle;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ActivityComponent;
import dagger.hilt.android.components.ApplicationComponent;
import dagger.hilt.android.scopes.ActivityScoped;


@InstallIn(ApplicationComponent.class)
@Module
public class JavaSingleModule {

    /**
     * 作用域：全局单例在ApplicationComponent上，并使用Singleton注解
     * @return
     */
    @Singleton
    @Provides
    public JavaSingle getJavaSingle(){
        return new JavaSingle();
    }
}
