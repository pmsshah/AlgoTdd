package com.example.array;

import com.example.array.ArrayAlgo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

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

    @Test
    void intToRoman() {
        String roman = arrayAlgo.intToRoman(3);
        System.out.println("Input: 3 Expected: III" + " Result: " + roman);
        Assertions.assertEquals("III", roman);
    }

    @ParameterizedTest
    @MethodSource
    void intToRomanAll(int num, String expected) {
        String roman = arrayAlgo.intToRoman(num);
        System.out.println("Input: " + num + " Expected: " + expected + " Result: " + roman);
        Assertions.assertEquals(expected, roman);
    }

    private static Stream<Arguments> intToRomanAll() {
        return Stream.of(
                arguments(5, "V"),
                arguments(3, "III"),
                arguments(58, "LVIII"),
                arguments(1994, "MCMXCIV")
        );
    }

    @Test
    void maxArea() {
        int[] height = {1,8,6,2,5,4,8,3,7};
        //int[] height = new int[] {1,8,6,2,5,4,8,3,7};
        int result = arrayAlgo.maxArea(height);
        System.out.println("Expected: 49" + " Result: " + result);
        Assertions.assertEquals(49, result);
    }

    @ParameterizedTest
    @MethodSource
    void maxAreaAll(int[] num, int expected) {
        int result = arrayAlgo.maxArea(num);
        System.out.println("Input: " + Arrays.toString(num) + " Expected: " + expected + " Result: " + result);
        Assertions.assertEquals(expected, result);
    }

    private static Stream<Arguments> maxAreaAll() {
        int arr1[] = {1,8,6,2,5,4,8,3,7};
        int arr2[] = {1,1};
        int arr3[] = {
                3846,
                7214,
                9316,
                9869,
                2423,
                4235,
                4921,
                5878,
                9832,
                5302,
                4298,
                4312,
                8571,
                531,
                2563};
        return Stream.of(
                arguments(arr1, 49),
                arguments(arr2, 1),
                arguments(arr3, 85710)
        );
    }

    @ParameterizedTest
    @ValueSource(strings = { "23", "", "239" })
    void TeliCombinations(String input) {
        List<String> allCombi = arrayAlgo.TeliCombinations(input);
        System.out.println("Input: " + input + " Result: "+allCombi + " Size: " + allCombi.size());
        Assertions.assertEquals(true, true);
    }

    @ParameterizedTest
    @MethodSource
    void TeliCombinationsAll(String input, int expected) {
        List<String> allCombi = arrayAlgo.TeliCombinations(input);
        System.out.println("Input: " + input + " Result: "+allCombi + " Size: " + allCombi.size());
        Assertions.assertEquals(expected, allCombi.size());
    }
    private static Stream<Arguments> TeliCombinationsAll() {
        return Stream.of(
                arguments("23", 9),
                arguments("2", 3),
                arguments("239", 36),
                arguments("", 0)
        );
    }
}