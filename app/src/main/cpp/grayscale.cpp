#include <opencv2/opencv.hpp>
#include <jni.h>

extern "C"
JNIEXPORT void JNICALL
Java_com_example_andsdk_GrayscaleConverter_convertToGrayscale(
        JNIEnv *env, jobject, jlong inputAddr, jlong outputAddr) {

    cv::Mat &input = *(cv::Mat *) inputAddr;
    cv::Mat &output = *(cv::Mat *) outputAddr;
    cv::cvtColor(input, output, cv::COLOR_RGBA2GRAY);
}
