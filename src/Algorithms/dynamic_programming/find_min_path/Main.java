package Algorithms.dynamic_programming.find_min_path;

//https://www.geeksforgeeks.org/min-cost-path-dp-6/


public class Main {

    public static int minCost(int[][] M, int ROW, int COL) {
        int[][] maxArr = new int[ROW][COL];
        maxArr[0][0] = M[0][0];

        //filling 1st column
        for(int i=1; i<ROW; i++)
            maxArr[i][0] = maxArr[i-1][0] + M[i][0];

        //filling 1st row
        for(int i=1; i<COL; i++)
            maxArr[0][i] = maxArr[0][i-1] + M[0][i];

        //filling remaining
        for(int i=1; i<ROW; i++)
            for(int j=1; j<COL; j++) {
                //here we are considering the movement down and right only.
                //if you consider diagonally than one more case will be added.
                // maxArr[i-1][j-1] and than find min among the three.
                maxArr[i][j] = Math.min(maxArr[i-1][j], maxArr[i][j-1]) + M[i][j];
            }

        return maxArr[ROW-1][COL-1];
    }

    public static void main(String[] args) {
        int[][] g = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(minCost(g, g.length, g[0].length));
    }
}
