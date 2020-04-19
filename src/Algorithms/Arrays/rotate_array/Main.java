package Algorithms.Arrays.rotate_array;

/*
* Reversal algorithm for array rotation: Write a function rotate(A[], d, n) that rotates
* A[] of size n by d elements. For example, the array 1,2,3,4,5,6,7 becomes 3,4,5,6,7,1,2
* after 2 rotations.
*
* Algorithm:
rotate(Array[], d, n)
reverse(Array[], 1, d) ;
reverse(Array[], d + 1, n);
reverse(Array[], 1, n);
* */

import java.util.Arrays;

public class Main {
    static int[] rotateLeft(int[] arr, int d) {
        int[] arr1 = _reverseArray(arr, 0, d-1);
        int[] arr2 = _reverseArray(arr1, d, arr.length-1);
        return _reverseArray(arr2, 0, arr.length-1);
    }
    static int[] _reverseArray(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[end];
            arr[end] = arr[start];
            arr[start] = temp;
            start++; end--;
        }
        return arr;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(rotateLeft(new int[] {1,2,3,4,5,6,7,8,9}, 3)));
    }
}
