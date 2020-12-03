cmake_minimum_required(VERSION 3.4.1)

project(vsomeip-hello-world)

list(APPEND CMAKE_MODULE_PATH ${CMAKE_SOURCE_DIR}/cmake)

add_subdirectory(external/boost-cmake)
add_subdirectory(external/vsomeip)
add_subdirectory(external/vsomeip/examples/hello_world)
add_subdirectory(vsomeip-hello-world/app/src/main/cpp)
