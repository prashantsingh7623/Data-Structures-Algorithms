package Algorithms.dynamic_programming.discrete_knapsack.with_repetition;

public class Main {
    public static int knapSackWithRep(int[] weights, int[] values, int capacity) {
        int rows = weights.length + 1;
        int cols = capacity + 1;

        int[][] arr = new int[rows][cols];

        for (int i = 1; i < rows; i++)
            for (int j = 1; j < cols; j++) {
                if (weights[i-1] > j)
                    arr[i][j] = arr[i-1][j];
                else {
                    arr[i][j] = Math.max(values[i-1] + arr[i][j - weights[i-1]],
                            arr[i-1][j]);
                }
            }
        return arr[rows-1][cols-1];
    }

    public static int knapSack(int[] weights, int[] values, int capacity) {
        int[] result = new int[capacity + 1];
        int val = 0;
        for(int w=1; w<capacity+1; w++) {
            result[w] = 0;
            for (int i=0; i<values.length; i++) {
                if (weights[i] <= w) {
                    val = result[w - weights[i]] + values[i];
                }
                if (val > result[w]) {
                    result[w] = val;
                }
            }
        }
        return result[capacity];
    }

    public static void main(String[] args) {
//        int[] weights = {1, 3, 4, 5};
//        int[] values = {10 ,40, 50, 70};
//        int capacity = 8;

        int[] weights = {1, 50};
        int[] values = {1, 30};
        int capacity = 100;
        System.out.println(knapSackWithRep(weights,values, capacity));
        System.out.println(knapSack(weights, values, capacity));
    }
}
