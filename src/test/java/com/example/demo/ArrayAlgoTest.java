package com.example.demo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class ArrayAlgoTest {

    ArrayAlgo arrayAlgo;

    @BeforeEach
    void setUp() {
        arrayAlgo = new ArrayAlgo();
    }

    @AfterEach
    void tearDown() {
    }

    @ParameterizedTest
    @ValueSource(strings = { "{}{}({()})", "{abc}{abc}({(123)})", "{}{}({()})" })
    void balanceBracket(String input) {
        boolean result = arrayAlgo.balanceBracket(input);
        System.out.println("Input: " + input + " Result: "+result);
        Assertions.assertEquals(true, result);
    }
}