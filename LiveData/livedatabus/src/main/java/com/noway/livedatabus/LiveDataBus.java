package com.noway.livedatabus;

import androidx.lifecycle.MutableLiveData;

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
public class LiveDataBus {




    //存放订阅者---> 消息总线
    private Map<String, MutableLiveData<Object>> mBusMap;


    private static LiveDataBus mInstance = new LiveDataBus();

    public static LiveDataBus getInstance(){
        return mInstance;
    }
    private LiveDataBus(){
        mBusMap = new HashMap<>();
    }


    /**
     * 注册订阅者
     */

    public synchronized <T>MutableLiveData<T> with(String key, Class<T> type){
        if (!mBusMap.containsKey(key)){
            mBusMap.put(key,new MutableLiveData<Object>());
        }
        return (MutableLiveData) mBusMap.get(key);

    }
}
