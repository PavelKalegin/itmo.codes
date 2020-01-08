package com.itmo.codes.golomb;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GolombCoderTest {

    @Test
    void encode() {
        assertEquals("110|101", GolombCoder.encode(21, 3));
        assertEquals("110|100", GolombCoder.encode(20, 3));
        assertEquals("110|011", GolombCoder.encode(19, 3));
    }

    @Test
    void decode() {
        assertEquals(21, GolombCoder.decode("110101", 3));
        assertEquals(20, GolombCoder.decode("110100", 3));
        assertEquals(19, GolombCoder.decode("110011", 3));
    }
}