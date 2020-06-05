cmake_minimum_required(VERSION 3.4.1)

add_library( MainActivityJNI SHARED MainActivityJNI.cpp )

add_library( ServiceVsomeipHelloWorldServiceJNI SHARED ServiceVsomeipHelloWorldServiceJNI.cpp )
target_link_libraries( ServiceVsomeipHelloWorldServiceJNI vsomeip_hello_world_service vsomeip3 vsomeip3-cfg vsomeip3-e2e vsomeip3-sd)

add_library( ServiceVsomeipHelloWorldClientJNI SHARED ServiceVsomeipHelloWorldClientJNI.cpp )
target_link_libraries( ServiceVsomeipHelloWorldClientJNI vsomeip_hello_world_client vsomeip3 vsomeip3-cfg vsomeip3-e2e vsomeip3-sd)