package Algorithms.Arrays.kadane_algorithm;

//maximum sum sub-array using kadane's algorithm

public class Main {
    static int findMaximumSumSubArray(int[] arr) {
        int max_current = arr[0], max_global = arr[0];
        for (int i=1; i < arr.length; i++) {
            max_current = Math.max(arr[i], max_current + arr[i]);
            if (max_current > max_global) { max_global = max_current; }
        }
        return max_global;
    }

    public static void main(String[] args) {
        int[] arr = {4, -3, -2, 2, 3, 1, -2, -3, 4, 2, -6, -3, -1, 3, 1, 2};
        System.out.println(findMaximumSumSubArray(arr));
    }
}
