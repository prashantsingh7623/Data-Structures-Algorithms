package Algorithms.Arrays.search_rot_sorted_arr;

//https://www.youtube.com/watch?v=6pSzsJH56BA
/*
* Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
You are given a target value to search. If found in the array return its index, otherwise return -1.
You may assume no duplicate exists in the array.
Your algorithm's runtime complexity must be in the order of O(log n).
* */

public class Main {

//    public static int findPivot(int[] arr, int start, int end) {
//        int pivot = 0;
//        if(arr[start] <= arr[end]) { return pivot; }
//        while(start < end) {
//            int mid = (start + end) / 2;
//            if (arr[mid] > arr[mid + 1]) { pivot = mid + 1; break; }
//            else if(arr[start] > arr[mid]) { end = mid - 1; }
//            else { start = mid + 1;}
//        }
//        return pivot;
//    }

    public static int _search(int[] arr, int start, int end, int target) {
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == target) { return mid; }
            if(arr[mid] < arr[end]) { //2nd half is sorted
                if (target >= arr[mid] && target <= arr[end]) {
                    start = mid + 1;
                } else { end = mid-1;}
            } else { //fist half is sorted
                if (target <= arr[mid] && target >= arr[start]) {
                    end = mid-1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {8,1};
        int target = 81;
        System.out.println(_search(arr, 0, arr.length-1, target));
    }
}
