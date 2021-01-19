package com.noway.livedatabus;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: dpq
 * @date: 2021/1/19
 * @email: dpq@arcvideo.com
 * @version: 2.5.0
 * @desc:
 */

/**
 * TODO 黏性消息
 */
public class LiveDataBusX {




    //存放订阅者---> 消息总线
    private Map<String, BusMutableLiveData<Object>> mBusMap;


    private static LiveDataBusX mInstance = new LiveDataBusX();

    public static LiveDataBusX getInstance(){
        return mInstance;
    }
    private LiveDataBusX(){
        mBusMap = new HashMap<>();
    }


    /**
     * 注册订阅者
     */

    public synchronized <T>BusMutableLiveData<T> with(String key, Class<T> type){
        if (!mBusMap.containsKey(key)){
            mBusMap.put(key,new BusMutableLiveData<Object>());
        }
        return (BusMutableLiveData) mBusMap.get(key);

    }

    public static class BusMutableLiveData<T> extends MutableLiveData<T>{

        @Override
        public void observe(@NonNull LifecycleOwner owner, @NonNull Observer<? super T> observer) {
            super.observe(owner, observer);
            hook(observer);
        }

        private void hook(Observer<? super T> observer) {
            //
            try {
                Class<LiveData> liveDataClass = LiveData.class;
                Field mObserversField = liveDataClass.getDeclaredField("mObservers");
                mObserversField.setAccessible(true);

                Object mObserversObject = mObserversField.get(this);

                Class<?> mObserversObjectClass = mObserversObject.getClass();
                Method get = mObserversObjectClass.getDeclaredMethod("get", Object.class);
                get.setAccessible(true);

                Object invokeEntry = get.invoke(mObserversObject, observer);

                Object observerWrapper = null;
                if (invokeEntry != null && invokeEntry instanceof  Map.Entry){
                    observerWrapper = ((Map.Entry) invokeEntry).getValue();
                }
                if (observerWrapper == null){
                    throw new NullPointerException("observerWrapper is null");
                }

                //获取到observerWrapper对象
                Class<?> superClass = observerWrapper.getClass().getSuperclass();
                //1、获取到mLastVersion
                Field mLastVersion = superClass.getDeclaredField("mLastVersion");
                mLastVersion.setAccessible(true);
                //2、获取到mVersion
                Field mVersion = liveDataClass.getDeclaredField("mVersion");
                mVersion.setAccessible(true);
                //3、mLastVersion = mVersion
                Object mVersionValue = mVersion.get(this);
                mLastVersion.set(observerWrapper,mVersionValue);

            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
