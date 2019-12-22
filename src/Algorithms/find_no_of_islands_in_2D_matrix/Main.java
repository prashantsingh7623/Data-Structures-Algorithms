package Algorithms.find_no_of_islands_in_2D_matrix;

import javax.swing.*;

public class Main {

    static int ROW, COL;

    //function to check whether the cell(i,j) is safe to explore.
    static boolean isSafe(int [][]M, int row, int col, boolean [][]visited) {
        return ((row >= 0) && (row < ROW) && (col >= 0) && (col < COL) &&
                M[row][col] == 1 && !visited[row][col]);
    }

    //function to explore cell(i,j)
    static void DFS(int [][]M, int row, int col, boolean [][]visited) {
        visited[row][col] = true;
        int rowNbr[] = {-1,-1,-1,0,0,1,1,1};
        int colNbr[] = {-1,0,1,-1,1,-1,0,1};
        for(int i = 0; i<8; i++) {
            if(isSafe(M, row + rowNbr[i], col + colNbr[i], visited)) {
                DFS(M, row + rowNbr[i], col + colNbr[i], visited);
            }
        }
    }

    //method to count the number of islands
    static int countIslands(int [][]M) {
        boolean [][]visited = new boolean[ROW][COL];
        int count = 0;
        for(int i=0; i<ROW; i++)
            for(int j=0; j<COL; j++)
                if(M[i][j] == 1 && !visited[i][j]) {

                    //we found the region. So increment the count and let DFS explore the region.
                    count ++;
                    DFS(M, i,j,visited);
                }
        return count;
    }

    public static void main(String[] args) {
        ROW = 5;
        COL = 5;
//        int [][] M = {{0,0,1,1,0},{1,0,1,1,0},{0,1,0,0,0},{0,0,0,0,1}};
        int [][]M = {{1,1,0,0,0},{0,1,0,0,1},{1,0,0,1,1},{0,0,0,0,0},{1,0,1,0,1}};
        System.out.println(Main.countIslands(M));
    }
}
