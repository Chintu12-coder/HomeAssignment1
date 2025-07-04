cmake_minimum_required(VERSION 3.4.1)

set(OpenCV_DIR /Users/himanshurana/Downloads/OpenCV-android-sdk/sdk/native/jni)

find_package(OpenCV REQUIRED)

add_library( # Sets the name of the library.
        native-lib
        SHARED
        grayscale.cpp )

find_library( log-lib log )

target_link_libraries(
        native-lib
        ${log-lib}
        ${OpenCV_LIBS} )
