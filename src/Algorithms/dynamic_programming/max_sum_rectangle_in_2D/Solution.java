package Algorithms.dynamic_programming.max_sum_rectangle_in_2D;

public class Solution {
  public static int[] kadane_algorithm(int[] arr) {
    int maxCurrent=arr[0], maxGlobal = arr[0];
    int start = 0, end = 0, s=0;
    for(int i=0; i<arr.length; i++) {
      maxCurrent = Math.max(arr[i], arr[i] + maxCurrent);
      if(maxCurrent > maxGlobal) { maxGlobal = maxCurrent; start = s; end = i;}
      else if(maxCurrent < 0) { s = i+1;}
    }
    return new int[]{maxGlobal, start, end};
  }
  public static void MaxSumRectangleIn2D(int[][] M) {
    int l=0, r=0;
    int currSum = 0, maxSum = Integer.MIN_VALUE;
    int maxUp=0, maxDown=0, maxRight=0, maxLeft=0;
    for(int i=0; i<M[0].length; i++) {
      int[] arr = new int[M.length];
      for(int j=i; j<M[0].length; j++) {
        l = i; r = j;
        int p=0;
        while(p<M.length) {
          arr[p] += M[p][j];
          p += 1;
        }
        int[] val = kadane_algorithm(arr);
        for(int a: arr) { System.out.print(a + " "); }
        System.out.println();
        for(int v: val) { System.out.print(v + " "); }
        System.out.println();
        currSum = val[0];
        if(currSum > maxSum) { 
          maxSum = currSum; 
          maxUp = val[1]; maxDown = val[2]; maxLeft = l; maxRight = r;
        }
      }
    }
    System.out.println(maxSum + " " + maxUp + " " + maxDown + " " + maxLeft + " " + maxRight);
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    int[][] arr = {{1,2,-1,4,-20}, {-8, -3,4,2,1}, {3,8,10,-8,3}, {-4,-1,1,7,6}};
    System.out.println(arr.length + " " + arr[0].length);
    Solution.MaxSumRectangleIn2D(arr);
  }
}

