package Algorithms.Arrays.chek_sorted_arr_using_recursion;

public class Main {

    static int checkSorted(int[] arr, int n) {
        if(n == 1 || n == 0) { return 1; }
        return (arr[n-1] < arr[n-2]) ? 0 : checkSorted(arr, n-1);
    }

    public static void main(String[] args) {
        int[] arr = {1,2,8,5};
        System.out.println(Main.checkSorted(arr, arr.length));
    }
}
