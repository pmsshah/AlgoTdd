package com.example.heap;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MaxHeapTest {

    MaxHeap maxHeap = null;

    @BeforeEach
    void setUp() {
        maxHeap = new MaxHeap(7);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testMinHeap() {
        maxHeap.insert(3);
        maxHeap.insert(16);
        maxHeap.insert(21);
        maxHeap.insert(13);
        maxHeap.insert(7);
        maxHeap.insert(9);
        maxHeap.insert(12);
        maxHeap.printHeap();

        maxHeap.maxHeap(); //rebuild all
        maxHeap.printHeap();

        System.out.println("\nThe Min Value removed : " + maxHeap.remove());
        maxHeap.printHeap();
    }
}