package com.itmo.codes.huffman;

import org.junit.jupiter.api.Test;

import java.util.Comparator;


class HuffmanEncoderTest {

    @Test
    void printGetCodeMap() {
        HuffmanEncoder.getCodeMap("abc abd a ")
                .entrySet()
                .stream()
                .sorted(Comparator.comparingInt(entry -> entry.getValue().length()))
                .forEachOrdered( entry -> System.out.println(entry.getKey() + " " + entry.getValue())
        );
    }
}