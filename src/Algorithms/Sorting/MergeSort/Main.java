package Algorithms.Sorting.MergeSort;

public class Main {

  public static void merge(int[] arr, int start, int mid, int end) {
    // find the size of 2 subarray's to be merged
    int n1 = mid - start + 1;
    int n2 = end - mid;

    //make temp arrays of that sizes
    int[] left_arr = new int[n1];
    int[] right_arr = new int[n2];

    // fill the temp arrays 
    for(int i=0; i<n1; i++)
      left_arr[i] = arr[i + start];

    for(int i=0; i<n2; i++)
      right_arr[i] = arr[i + mid + 1];

    // merging the arrays
    int p = 0, q = 0;
    while(p < n1 && q < n2) {
      int first = left_arr[p];
      int second = right_arr[q];
      if (first <= second) {
        arr[start] = first;
        p += 1;
      } else {
        arr[start] = second;
        q += 1;
      }
      start += 1;
    }

    // copy remaining elements of first array if any
    for(int i=p; i<n1; i++)
      arr[start++] = left_arr[i];
    
    for(int i=q; i<n2; i++)
      arr[start++] = right_arr[i];
  }
  public static void mergeSort(int[] arr, int left, int right) {
    if(left < right) {
      int mid = (left + right) / 2;
      mergeSort(arr, left, mid);
      mergeSort(arr, mid+1, right);
      merge(arr, left, mid, right);
    }
  }
  public static void main(String[] args) {
    int[] arr = {0,1,2,0,1,2,3,7,5,4};
    mergeSort(arr, 0, arr.length-1);
    for(int i=0; i<arr.length; i++)
      System.out.print(arr[i] + " ");
  }
}
