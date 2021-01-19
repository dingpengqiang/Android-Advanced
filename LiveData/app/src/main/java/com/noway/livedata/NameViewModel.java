package com.noway.livedata;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * @author: dpq
 * @date: 2021/1/19
 * @email: dpq@arcvideo.com
 * @version: 2.5.0
 * @desc:
 */
public class NameViewModel extends ViewModel {

    private MutableLiveData<String>  currentName;


    public MutableLiveData<String> getCurrentName() {
        if (currentName == null){
            currentName = new MutableLiveData<>();
        }
        return currentName;
    }
}
