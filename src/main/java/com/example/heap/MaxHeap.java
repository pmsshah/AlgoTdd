package com.example.heap;

import java.util.Arrays;

public class MaxHeap {
    private int[] Heap;
    private int index;
    private int size;

    public MaxHeap(int size) {
        this.size = size;
        this.index = 0;
        Heap = new int[size];
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }

    private int leftChild(int i) {
        return (i * 2) + 1;
    }

    private int rightChild(int i) {
        return (i * 2) + 2;
    }

    private boolean isLeaf(int i) {
        if (rightChild(i) >= size || leftChild(i) >= size) {
            return true;
        }
        return false;
    }
    // swaps two nodes of the heap
    private void swap(int x, int y) {
        int tmp;
        tmp = Heap[x];
        Heap[x] = Heap[y];
        Heap[y] = tmp;
    }
    // heapify the node at i
    private void maxHeapify(int i) {
        // If the node is a non-leaf node and any of its child is smaller
        if (!isLeaf(i)) {
            if (Heap[i] < Heap[leftChild(i)] ||
                    Heap[i] < Heap[rightChild(i)]) {
                if (Heap[leftChild(i)] > Heap[rightChild(i)]) {
                    swap(i, leftChild(i));
                    maxHeapify(leftChild(i));
                } else {
                    swap(i, rightChild(i));
                    maxHeapify(rightChild(i));
                }
            }
        }
    }
    public void insert(int element) {
        if (index >= size) {
            return;
        }
        Heap[index] = element;
        int current = index;

        while (Heap[current] > Heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
        index++;
    }

    // removes and returns the minimum element from the heap
    public int remove() {
        // since its a min heap, so root = minimum
        int popped = Heap[0];
        Heap[0] = Heap[--index];
        maxHeapify(0);
        return popped;
    }
    // builds the min-heap using the maxHeapify
    public void maxHeap() {
        for (int i = (index - 1 / 2); i >= 1; i--) {
            maxHeapify(i);
        }
    }

    // Function to print the contents of the heap
    public void printHeap() {
        if(index<size)
            System.out.println("The Min Heap is : " + Arrays.toString(Arrays.copyOfRange(Heap, 0, index)));
        else
            System.out.println("The Min Heap is : " + Arrays.toString(Heap));
        System.out.println("Index: " + index + " Size: " + size);
        for (int i = 0; i < (index / 2); i++) {
            System.out.print("Parent : " + Heap[i]);
            if (leftChild(i) < index)
                System.out.print(" Left : " + Heap[leftChild(i)]);
            if (rightChild(i) < index)
                System.out.print(" Right :" + Heap[rightChild(i)]);
            System.out.println();
        }
    }

}
