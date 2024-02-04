
package com.mycompany.heaptree;

public class HeapTree {

    static class MaxHeap {
        private int[] heap;
        private int size;
        private int capacity;

        public MaxHeap(int capacity) {
            this.capacity = capacity;
            this.size = 0;
            this.heap = new int[capacity + 1];
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public void insert(int value) {
            if (size == capacity) {
                System.out.println("Max Heap is full. Cannot insert " + value);
                return;
            }

            size++;
            heap[size] = value;
            int current = size;

            while (heap[current] > heap[parent(current)]) {
                swap(current, parent(current));
                current = parent(current);
            }
        }

        public void printHeap() {
            for (int i = 1; i <= size / 2; i++) {
                System.out.print(" Parent: " + heap[i] +
                        " Left Child: " + heap[2 * i] +
                        " Right Child: " + heap[2 * i + 1]);
                System.out.println();
            }
        }

        private int parent(int pos) {
            return pos / 2;
        }

        private void swap(int fpos, int spos) {
            int tmp;
            tmp = heap[fpos];
            heap[fpos] = heap[spos];
            heap[spos] = tmp;
        }
    }

    static class MinHeap {
        private int[] heap;
        private int size;
        private int capacity;

        public MinHeap(int capacity) {
            this.capacity = capacity;
            this.size = 0;
            this.heap = new int[capacity + 1];
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public void insert(int value) {
            if (size == capacity) {
                System.out.println("Min Heap is full. Cannot insert " + value);
                return;
            }

            size++;
            heap[size] = value;
            int current = size;

            while (heap[current] < heap[parent(current)]) {
                swap(current, parent(current));
                current = parent(current);
            }
        }

        public void printHeap() {
            for (int i = 1; i <= size / 2; i++) {
                System.out.print(" Parent: " + heap[i] +
                        " Left Child: " + heap[2 * i] +
                        " Right Child: " + heap[2 * i + 1]);
                System.out.println();
            }
        }

        private int parent(int pos) {
            return pos / 2;
        }

        private void swap(int fpos, int spos) {
            int tmp;
            tmp = heap[fpos];
            heap[fpos] = heap[spos];
            heap[spos] = tmp;
        }
    }

    public static void main(String[] args) {
        // Max Heap örneği
        MaxHeap maxHeap = new MaxHeap(10);
        maxHeap.insert(4);
        maxHeap.insert(10);
        maxHeap.insert(3);
        maxHeap.insert(5);
        maxHeap.insert(1);

        System.out.println("Max Heap:");
        maxHeap.printHeap();

        // Min Heap örneği
        MinHeap minHeap = new MinHeap(10);
        minHeap.insert(4);
        minHeap.insert(10);
        minHeap.insert(3);
        minHeap.insert(5);
        minHeap.insert(1);

        System.out.println("Min Heap:");
        minHeap.printHeap();
    }
}