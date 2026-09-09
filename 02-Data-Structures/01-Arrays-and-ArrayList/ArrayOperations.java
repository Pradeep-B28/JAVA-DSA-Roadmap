import java.util.Arrays;

/**
 * Phase 2: Data Structures - Arrays & Sliding Window / Two Pointers
 */
public class ArrayOperations {

    // Two Pointer Technique: Reverse Array in O(N)
    public static void reverseArray(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    // Sliding Window Technique: Maximum sum of subarray of size K
    public static int maxSubarraySumK(int[] arr, int k) {
        if (arr.length < k) return -1;
        int windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }
        int maxSum = windowSum;
        for (int i = k; i < arr.length; i++) {
            windowSum += arr[i] - arr[i - k];
            maxSum = Math.max(maxSum, windowSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] numbers = {2, 1, 5, 1, 3, 2};
        System.out.println("Original Array: " + Arrays.toString(numbers));

        reverseArray(numbers);
        System.out.println("Reversed Array: " + Arrays.toString(numbers));

        int k = 3;
        int maxSum = maxSubarraySumK(numbers, k);
        System.out.println("Max Sum Subarray of size " + k + ": " + maxSum);
    }
}
