#include <jni.h>
#include <string>
#include "include/opencv2/core/mat.hpp"
#include "include/opencv2/core/types.hpp"

#define DEFAULT_CARD_WIDTH 640
#define DEFAULT_CARD_HEIGHT 400
#define  FIX_IDCARD_SIZE Size(DEFAULT_CARD_WIDTH,DEFAULT_CARD_HEIGHT)
#define FIX_TEMPLATE_SIZE  Size(153, 28)


extern "C" {

using namespace cv;
using namespace std;
extern JNIEXPORT void JNICALL Java_org_opencv_android_Utils_nBitmapToMat2
        (JNIEnv *env, jclass, jobject bitmap, jlong m_addr, jboolean needUnPremultiplyAlpha);
JNIEXPORT void JNICALL Java_org_opencv_android_Utils_nMatToBitmap
        (JNIEnv *env, jclass, jlong m_addr, jobject bitmap);

JNIEXPORT jstring JNICALL
Java_com_noway_idcardrec_MainActivity_stringFromJNI(
        JNIEnv *env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}

JNIEXPORT jobject JNICALL
Java_com_noway_idcardrec_OpenCVIDCardJNI_getIdNumber(JNIEnv *env,
                                                     jobject thiz,
                                                     jobject src,
                                                     jobject config) {

    Mat src_img;
    Mat dst_img;
    Java_org_opencv_android_Utils_nBitmapToMat2(env, thiz, src, (jlong) &src_img, 0);

    Mat dst;
    //无损压缩//640*400
    resize(src_img, src_img, FIX_IDCARD_SIZE);
    //imshow("dst", src_img);
    //灰度化
    cvtColor(src_img, dst, COLOR_BGR2GRAY);
    //imshow("gray", dst);

    //二值化
    threshold(dst, dst, 100, 255, CV_THRESH_BINARY);
    //imshow("threshold", dst);

    //加水膨胀，发酵
    Mat erodeElement = getStructuringElement(MORPH_RECT, Size(20, 10));
    erode(dst, dst, erodeElement);
    //imshow("erode", dst);

    ////轮廓检测 // arraylist
    vector<vector<Point> > contours;
    vector<Rect> rects;

    findContours(dst, contours, RETR_TREE, CHAIN_APPROX_SIMPLE, Point(0, 0));
}

}
