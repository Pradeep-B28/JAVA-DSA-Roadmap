import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Binary Heap and PriorityQueue Demonstration
 * Demonstrates:
 * 1. Array-based MinHeap implementation with siftUp and siftDown
 * 2. Standard Java PriorityQueue (Min-Heap and Max-Heap)
 * 3. Kth Largest Element algorithm using a Min-Heap
 */
public class HeapDemo {

    // 1. Custom Min-Heap Implementation
    public static class MinHeap {
        private final int[] heap;
        private int size;
        private final int capacity;

        public MinHeap(int capacity) {
            this.capacity = capacity;
            this.size = 0;
            this.heap = new int[capacity];
        }

        private int parent(int i) { return (i - 1) / 2; }
        private int leftChild(int i) { return 2 * i + 1; }
        private int rightChild(int i) { return 2 * i + 2; }

        private void swap(int i, int j) {
            int temp = heap[i];
            heap[i] = heap[j];
            heap[j] = temp;
        }

        public void insert(int val) {
            if (size == capacity) {
                throw new IllegalStateException("Heap is full");
            }
            heap[size] = val;
            int current = size;
            size++;

            // Sift-up
            while (current > 0 && heap[current] < heap[parent(current)]) {
                swap(current, parent(current));
                current = parent(current);
            }
        }

        public int extractMin() {
            if (size == 0) {
                throw new IllegalStateException("Heap is empty");
            }
            int root = heap[0];
            heap[0] = heap[size - 1];
            size--;
            siftDown(0);
            return root;
        }

        private void siftDown(int i) {
            int smallest = i;
            int left = leftChild(i);
            int right = rightChild(i);

            if (left < size && heap[left] < heap[smallest]) {
                smallest = left;
            }
            if (right < size && heap[right] < heap[smallest]) {
                smallest = right;
            }
            if (smallest != i) {
                swap(i, smallest);
                siftDown(smallest);
            }
        }

        public int peek() {
            if (size == 0) throw new IllegalStateException("Heap is empty");
            return heap[0];
        }

        public int size() {
            return size;
        }
    }

    // 2. Kth Largest Element using PriorityQueue
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);
        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }

    public static void main(String[] args) {
        System.out.println("=== 1. Custom Min-Heap ===");
        MinHeap customHeap = new MinHeap(10);
        int[] values = {35, 12, 42, 8, 19, 27};
        for (int v : values) customHeap.insert(v);

        System.out.print("Extracted elements in sorted order: ");
        while (customHeap.size() > 0) {
            System.out.print(customHeap.extractMin() + " ");
        }
        System.out.println();

        System.out.println("\n=== 2. Kth Largest Element ===");
        int[] arr = {3, 2, 1, 5, 6, 4};
        int k = 2;
        System.out.println(k + "nd largest in " + Arrays.toString(arr) + " = " + findKthLargest(arr, k));
    }
}
