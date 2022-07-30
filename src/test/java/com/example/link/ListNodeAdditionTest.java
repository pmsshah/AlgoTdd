package com.example.link;

import com.example.array.ArrayAlgo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class ListNodeAdditionTest {

    ListNodeAddition s;

    @BeforeEach
    void setUp() {
        s = new ListNodeAddition();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void addTwoList_sample1() {
        ListNode l1 = s.getList(243);
        String l1Str = s.printList(l1);
        Assertions.assertEquals("2, 4, 3, ", l1Str);
        ListNode l2 = s.getList(564);
        String l2Str = s.printList(l2);
        Assertions.assertEquals("5, 6, 4, ", l2Str);
        ListNode result = s.addTwoNumbers(l1, l2);
        String resultStr = s.printList(result);
        Assertions.assertEquals("7, 0, 8, ", resultStr);
    }

    @Test
    void addTwoList_sample2() {
        ListNode l1 = s.getList(9999999);
        String l1Str = s.printList(l1);
        Assertions.assertEquals("9, 9, 9, 9, 9, 9, 9, ", l1Str);
        ListNode l2 = s.getList(9999);
        String l2Str = s.printList(l2);
        Assertions.assertEquals("9, 9, 9, 9, ", l2Str);
        ListNode result = s.addTwoNumbers(l1, l2);
        String resultStr = s.printList(result);
        Assertions.assertEquals("8, 9, 9, 9, 0, 0, 0, 1, ", resultStr);
    }

    @Test
    void addTwoList_sample3() {
        ListNode l1 = s.getList(0);
        String l1Str = s.printList(l1);
        //System.out.println("Result 1:" + l1Str + ":");
        ListNode l2 = s.getList(0);
        String l2Str = s.printList(l2);
        //System.out.println("Result 2:" + l2Str + ":");
        ListNode result = s.addTwoNumbers(l1, l2);
        String resultStr = s.printList(result);
        //System.out.println("Result :" + resultStr + ":");
        Assertions.assertEquals("", l1Str);
        Assertions.assertEquals("", l2Str);
        Assertions.assertEquals("", resultStr);
    }
}