package Algorithms.find_no_of_islands_in_2D_matrix;

import javax.swing.*;

public class Main {

    static int ROW, COL, count;

    static boolean isSafe(int [][]M, int row, int col, boolean [][]visited) {
        return ((row >= 0) && (col >= 0) && (row < ROW) && (col < COL)
                && M[row][col] == 1 && !visited[row][col]);
    }

    static void DFS(int [][]M, int row, int col, boolean visited[][]) {

        visited[row][col] = true;

        int []rowNbr = {-1,-1,-1,0,0,1,1,1};
        int []colNbr = {-1,0,1,-1,1,-1,0,1};

        for(int i = 0; i<8; i++) {
            if(isSafe(M, row + rowNbr[i], col + colNbr[i], visited)) {
                count ++;
                DFS(M, row + rowNbr[i], col + colNbr[i], visited);
            }
        }
    }

    static int largestResult(int [][]M) {
        boolean visited[][] = new boolean[ROW][COL];
        int result = 0;
        for(int i =0; i < ROW; i++) {
            for(int j = 0; j<COL; j++) {
               if(M[i][j] == 1 && !visited[i][j]) {
                   count = 1;
                   DFS(M, i, j, visited);
                   result = Math.max(result,count);
               }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ROW = 4;
        COL = 5;
        int [][] M = {{0,0,1,1,0},{1,0,1,1,0},{0,1,0,0,0},{0,0,0,0,1}};
        System.out.println(Main.largestResult(M));
    }
}
