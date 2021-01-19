package com.noway.idcardrec;

import android.graphics.Bitmap;

/**
 * @author: dpq
 * @date: 2020/12/24
 * @email: dpq@arcvideo.com
 * @version: 2.5.0
 * @desc:
 */
public class OpenCVIDCardJNI {

    static {
        System.loadLibrary("native-lib");
    }

    private native Bitmap getIdNumber(Bitmap src,Bitmap.Config config);


}
