package Algorithms.Arrays.stock_buy_sell_3;

// https://www.youtube.com/watch?v=oDhu5uGq_ic

public class Main {
  public static int maxProfit(int[] prices, int k) {
    int d_arr[][] = new int[k+1][prices.length];

    for(int i=1; i<d_arr.length; i++) {
      int maxDiff = -prices[0];
      for(int j=1; j<d_arr[0].length; j++) {
        d_arr[i][j] = Math.max(d_arr[i][j-1], prices[j] + maxDiff);
        maxDiff = Math.max(maxDiff, d_arr[i-1][j] - prices[j]);
      }
    }
    return d_arr[k][prices.length-1];
  }
  public static void main(String[] args) {
    int[] arr = {3,3,5,0,0,3,1,4};
    int k = 2;
    System.out.println(maxProfit(arr, k));
  }
}