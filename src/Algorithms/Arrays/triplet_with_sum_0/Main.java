package Algorithms.Arrays.triplet_with_sum_0;

/*
* Find all triplets with zero sum

Given an array of distinct elements. The task is to find triplets in the array whose sum is zero.

Examples :

Input : arr[] = {0, -1, 2, -3, 1}
Output : (0 -1 1), (2 -3 1)

* */

import java.util.HashSet;

public class Main {
    public static void findTriplet(int[] arr) {
        HashSet<Integer> hashSet;

        for (int i=0; i<arr.length-1; i++) {
            hashSet = new HashSet<>();
            for (int j=i+1; j<arr.length; j++) {
                int temp = -(arr[i] + arr[j]);
                if (hashSet.contains(temp)) {
                    System.out.println("hashset : " + hashSet.toString());
                    System.out.println("triplet : " + arr[i] + " " + temp + " " + arr[j]);
                } else {
                    hashSet.add(arr[j]);
                }
            }
        }
    }

    public static void main(String[] args) {
        findTriplet(new int[] {0, -1, 2, -3, 1});
    }
}
