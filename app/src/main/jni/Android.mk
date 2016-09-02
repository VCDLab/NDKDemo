LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)

#opencv
#include ../../../../opencv-native/jni/OpenCV.mk
subdirs +=$(LOCAL_PATH)/../opencv-native/jni/OpenCV.mk
include $(subdirs)
OPENCV_CAMERA_MODULES:=on
OPENCV_INSTALL_MODULES:=on
OPENCV_LIB_TYPE:=SHARED

LOCAL_SRC_FILES += imgproc.cpp test/mytest.cpp
LOCAL_LDLIBS += -llog
LOCAL_MODULE := gray-process

include $(BUILD_SHARED_LIBRARY)