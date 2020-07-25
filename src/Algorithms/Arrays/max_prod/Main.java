package Algorithms.Arrays.max_prod;

public class Main {
  static int maxProd(int[] arr) {
    int curr_max_prod = arr[0];
    int curr_min_prod = arr[0];
    int prev_max_prod = arr[0];
    int prev_min_prod = arr[0];
    int ans = arr[0];

    for(int i=1; i<arr.length; i++) {
      curr_max_prod = Math.max(Math.max(prev_max_prod * arr[i], prev_min_prod * arr[i]), arr[i]);
      curr_min_prod = Math.min(Math.min(prev_max_prod * arr[i], prev_min_prod * arr[i]), arr[i]);

      ans = Math.max(ans, curr_max_prod);
      
      prev_max_prod = curr_max_prod;
      prev_min_prod = curr_min_prod;
    }
    return ans ;
  }
  public static void main(String[] args) {
    int[] arr = {-1, 6, 2, 0, 7, 9};
    System.out.println(maxProd(arr));
    
  }
}