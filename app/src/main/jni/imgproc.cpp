#include <jni.h>
/* Header for class com_kuan_vision_ndkdemo_MainActivity */
#include <opencv2/opencv.hpp>

#include <test/mytest.h>

extern "C" {
using namespace cv;
using namespace std;

/*
 * Class:     com_kuan_vision_ndkdemo_MainActivity
 * Method:    grapyproc
 * Signature: ([III)[I
 */
JNIEXPORT jintArray JNICALL Java_com_kuan_vision_ndkdemo_MainActivity_grapyproc
  (JNIEnv *env, jclass obj, jintArray buf, jint w, jint h)
  {
     jboolean ptfalse = false;
     jint* srcBuf = env->GetIntArrayElements(buf, &ptfalse);
     if(srcBuf == NULL){
        return 0;
     }

     int size = w*h;

     cv::Mat srcImage(h,w, CV_8UC4, (unsigned char*)srcBuf);

  /*
     cv::Mat grayImage;
     cv::cvtColor(srcImage, grayImage, COLOR_BGRA2GRAY);
     cv::cvtColor(grayImage, srcImage, COLOR_GRAY2BGRA);
  */

     test(srcImage);

     jintArray result = env->NewIntArray(size);
     env->SetIntArrayRegion(result, 0, size, srcBuf);
     env->ReleaseIntArrayElements(buf, srcBuf, 0);


     return result;
  }

}