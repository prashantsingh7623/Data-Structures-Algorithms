package Algorithms.dynamic_programming.discrete_knapsack.without_repetition;

//https://www.youtube.com/watch?v=8LusJS5-AGo

public class Main {
    public static int KnapsackWithoutRep(int[] values, int[] weights, int capacity) {
        int no_of_items = values.length;
        int rows = no_of_items + 1;
        int cols = capacity + 1;

        int[][] arr = new int[rows][cols];

        for (int i=1; i<rows; i++) {
            for (int j=1; j<cols; j++) {
                if (j < weights[i-1])
                    arr[i][j] = arr[i-1][j];
                else {
                    arr[i][j] = Math.max(values[i-1] + arr[i-1][j - weights[i-1]], arr[i-1][j]);
                }
            }
        }
        return arr[rows-1][cols-1];
    }

    public static void main(String[] args) {
        int[] weights = {1, 4 ,8};
        int[] values = {1, 4 ,8};
        int capacity = 10;
        System.out.println(KnapsackWithoutRep(values, weights, capacity));
    }
}