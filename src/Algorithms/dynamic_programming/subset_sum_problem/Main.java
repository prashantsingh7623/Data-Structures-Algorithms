package Algorithms.dynamic_programming.subset_sum_problem;

public class Main {
    public static boolean subsetSumUsingDP(int s, int[] values) {
        int rows = values.length + 1;
        int cols = s + 1;

        boolean[][] arr = new boolean[rows][cols];

        for (int i=0; i<rows; i++) {
            arr[i][0] = true;
        }

        for (int i=1; i<rows; i++) {
            for (int j=1; j<cols; j++) {
                if (values[i-1] > j) {
                    arr[i][j] = arr[i-1][j];
                } else {
                    arr[i][j] = arr[i-1][j] || arr[i-1][j-values[i-1]];
                }
            }
        }
        return arr[rows-1][cols-1];
    }

    public static void main(String[] args) {
        int[] values = {1, 2, 5, 7};
        int s = 8;
        System.out.println(subsetSumUsingDP(s, values));
    }
}
