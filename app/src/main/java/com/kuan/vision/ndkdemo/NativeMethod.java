package com.kuan.vision.ndkdemo;

import org.opencv.android.OpenCVLoader;

/**
 * Created by zhuang on 16/8/29.
 */
public class NativeMethod {
    static{
        System.loadLibrary("JniDemo");
       // System.loadLibrary("opencv_java3");

    }



    public static native String getStrinFromC();


}
