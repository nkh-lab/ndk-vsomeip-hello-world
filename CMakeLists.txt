cmake_minimum_required(VERSION 3.4.1)

project(vsomeip-hello-world)

#
# Due to find_package limitation we need to workaround it with custom one
#
# Usage example:
# ndk_find_package_boost(log thread system)
#
macro(ndk_find_package_boost)

    unset(Boost_LIBRARIES)

    foreach(arg IN ITEMS ${ARGN})
        list(APPEND Boost_LIBRARIES Boost::${arg})
    endforeach()

    set(Boost_VERSION 107100)
    set(Boost_INCLUDE_DIR ${CMAKE_BINARY_DIR}/_deps/boost-src)
    set(Boost_FOUND TRUE)

endmacro()

add_subdirectory(external/boost-cmake)
add_subdirectory(external/vsomeip)
add_subdirectory(external/vsomeip/examples/hello_world)
add_subdirectory(vsomeip-hello-world/app/src/main/cpp)
