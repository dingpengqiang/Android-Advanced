package com.noway.hilt.ioc.module;

import com.noway.hilt.ioc.module.JavaObject;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ActivityComponent;
import dagger.hilt.android.scopes.ActivityScoped;


@InstallIn(ActivityComponent.class)
@Module
public class JavaModule {

        @Provides
        public JavaObject getJavaObject(){
            return new JavaObject();
        }
}
