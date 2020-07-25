package Algorithms.Sorting.Sorting_0s_1s_2s;

// http://users.monash.edu/~lloyd/tildeAlgDS/Sort/Flag/
// inplace sorting - 
// time complexity = O(N)
// space complexity = O(1)

public class Main {
  public static void sort012(int[] arr) {
    int lo = 0, mid = 0, hi = arr.length - 1;
    while(mid <= hi) {
      switch(arr[mid]) {
        case 0: {
          int temp = arr[lo];
          arr[lo] = arr[mid];
          arr[mid] = temp;
          lo += 1;
          mid += 1;
          break;
        }
        case 1: {
          mid += 1;
          break;
        }
        case 2: {
          int temp = arr[hi];
          arr[hi] = arr[mid];
          arr[mid] = temp;
          hi -= 1;
          break;
        }
      }
    }
  }
  public static void main(String[] args) {
    int[] arr = {0,1,2,0,1,2};
    sort012(arr);
    for(int i:arr)
      System.out.print(i + " ");
  }  
}