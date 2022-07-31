package com.example.heap;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MinHeapTest {

    MinHeap minHeap = null;

    @BeforeEach
    void setUp() {
        minHeap = new MinHeap(7);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testMinHeap() {
        minHeap.insert(3);
        minHeap.insert(16);
        minHeap.insert(21);
        minHeap.insert(13);
        minHeap.insert(7);
        minHeap.insert(9);
        minHeap.insert(12);
        minHeap.printHeap();

        minHeap.minHeap(); //rebuild all
        minHeap.printHeap();

        System.out.println("\nThe Min Value removed : " + minHeap.remove());
        minHeap.printHeap();
    }
}