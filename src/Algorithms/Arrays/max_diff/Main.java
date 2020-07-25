package Algorithms.Arrays.max_diff;

// https://www.geeksforgeeks.org/maximum-difference-between-two-elements/

public class Main {
  static int maxDiff(int[] arr, int n) {
    int maxDiff = -1;
    int max_right = arr[n - 1];

    for(int i=n-2; i>=0; i--) {
      if (arr[i] > max_right)
        max_right = arr[i];
      else {
        int diff = max_right - arr[i];
        if(diff > maxDiff) {
          maxDiff = diff;
        }
      }
    }
    return maxDiff;
  }
  public static void main(String[] args) {
    int[] arr = {4, 10, 3, 8, 2, 9};
    System.out.println(maxDiff(arr, arr.length));
  }
}