#include <jni.h>
#include <string>
#include <future>

#include "hello_world_service.hpp"

static std::future<void> gFuture;

extern "C" JNIEXPORT jstring JNICALL
Java_com_example_vsomeiphelloworld_ServiceVsomeipHelloWorldService_runNative(
        JNIEnv *env,
        jobject /* this */) {
    std::string hello = "Hello from ServiceVsomeipHelloWorldServiceJNI";

    gFuture = std::async(std::launch::async, []() {
        hello_world_service hw_srv;

        if (hw_srv.init()) {
            hw_srv.start();
        }
    });

    return env->NewStringUTF(hello.c_str());
}
