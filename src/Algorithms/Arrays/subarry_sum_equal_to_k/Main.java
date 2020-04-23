package Algorithms.Arrays.subarry_sum_equal_to_k;

//https://www.geeksforgeeks.org/number-subarrays-sum-exactly-equal-k/
//https://www.youtube.com/watch?v=HbbYPQc-Oo4
//https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/531/week-4/3307/

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static int findSubArrays(int[] arr, int k) {
        int tot = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int currSum = 0;
        for (int value : arr) {
            currSum += value;
            if (currSum == k) { tot += 1; }
            if (map.containsKey(currSum - k)) {
                tot += map.get(currSum - k);
            }
            if (!map.containsKey(currSum)) { map.put(currSum, 1); }
            else { map.put(currSum, map.get(currSum) + 1); }
        }

        return tot;
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, 7, 2, -3, 1, 4, 2};
        System.out.println(findSubArrays(arr, 7));
    }
}
