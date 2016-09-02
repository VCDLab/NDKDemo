#include "mytest.h"

using namespace cv;

void test(cv::Mat& srcImg)
{
     cv::Mat grayImage;
     cv::cvtColor(srcImg, grayImage, cv::COLOR_BGRA2GRAY);
     cv::cvtColor(grayImage, srcImg, cv::COLOR_GRAY2BGRA);
}