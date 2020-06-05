#include <jni.h>
#include <string>
#include <future>

#include "hello_world_client.hpp"

static std::future<void> gFuture;

extern "C" JNIEXPORT jstring JNICALL
Java_com_example_vsomeiphelloworld_ServiceVsomeipHelloWorldClient_runNative(
        JNIEnv *env,
        jobject /* this */) {
    std::string hello = "Hello from ServiceVsomeipHelloWorldClientJNI";

    gFuture = std::async(std::launch::async, []() {
        hello_world_client hw_clt;

        if (hw_clt.init()) {
            hw_clt.start();
        }
    });

    return env->NewStringUTF(hello.c_str());
}
