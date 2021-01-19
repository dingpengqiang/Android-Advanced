cmake_minimum_required(VERSION 3.10.2)


project("idcardrec")

include_directories(src/main/cpp/include)

#导入库文件
set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -L${CMAKE_SOURCE_DIR}/libs/${ANDROID_ABI}")

add_library( # Sets the name of the library.
             native-lib

             # Sets the library as a shared library.
             SHARED

             # Provides a relative path to your source file(s).
             native-lib.cpp )


find_library( # Sets the name of the path variable.
              log-lib

              # Specifies the name of the NDK library that
              # you want CMake to locate.
              log )


target_link_libraries( # Specifies the target library.
                       native-lib
                        #添加opencv_java4
                        opencv_java4

                        android
                       # Links the target library to the log library
                       # included in the NDK.
                       ${log-lib} )