#include "PCH.h"
#include <cstdint>
#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

namespace Native {

    using int16 = std::int16_t;
    using int32 = std::int32_t;
    using int64 = std::int64_t;

    /** Return a primitive value on the stack. */
    EXPORTED int32 testPrimitiveReturn() {
        std::cout << "Hello." << std::endl;
        return 42;
    }

    /** Allocate a return value on the heap. */
    EXPORTED int32* testHeapAllocation() {
        std::cout << "Hello." << std::endl;
        int32* mem = new int32{ 42 };
        return mem;
    }

    /** Just checking that STL features work. */
    EXPORTED const char* testSTL(int16 length) {
        // Generate a string of consecutively decreasing numbers, starting with 'length' - 1, ending with 0
        std::vector<int16> vec;
        for (int16 i = 0; i < length; i++) {
            vec.push_back(i);
        }
        std::string s;
        std::for_each(vec.rbegin(), vec.rend(), [&](int16 x) {
            s.append(std::to_string(x)).append(" ");
            });
        // Can't really get around a manual alloc when handing memory back to Java
        char* const copy = new char[s.length() + 1];
        std::copy(s.c_str(), s.c_str() + s.length() + 1, copy);
        return copy;
    }

    struct TestStruct {
        int32 x;
        float y;
    };

    /** Return a struct with some primitives inside. */
    EXPORTED TestStruct testStructReturn() {
        return { 4, 63.0f };
    }
}