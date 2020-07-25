package Algorithms.Arrays.stock_buy_sell_2;

public class Main {
  public static int stock2(int[] prices) {
    int max_profit = 0;
    int start = 0, end = 0;
    boolean enter = true;
    for(int i=1; i<prices.length; i++) {
      if(prices[i] > prices[i-1]) {
        max_profit += prices[i] - prices[i-1];
        if(enter) { start = i; enter = false;}
      }
      else { end = i; enter = true; System.out.println("s : " + start + " end : " + end);}
    }
    return max_profit;
  }
  public static void main(String[] args) {
    int[] arr = {3,1,5,6,8,2,4};
    System.out.println(stock2(arr));
  }
}