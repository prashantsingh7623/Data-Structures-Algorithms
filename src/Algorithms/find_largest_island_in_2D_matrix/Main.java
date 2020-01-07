package Algorithms.find_largest_island_in_2D_matrix;

public class Main {

    static int ROW, COL, count;

    //method to check whether the cell(i,j) is safe to explore.
    static boolean isSafe(int [][]M, int row, int col, boolean [][]visited) {
        return ((row >= 0) && (col >= 0) && (row < ROW) && (col < COL)
                && M[row][col] == 1 && !visited[row][col]);
    }

    //method to explore cell(i,j)
    static void DFS(int [][]M, int row, int col, boolean[][] visited) {

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

    //method to find the largest path to ones
    static int largestResult(int [][]M) {
        boolean[][] visited = new boolean[ROW][COL];
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
        ROW = 5;
        COL = 5;
//        int [][] M = {{0,0,1,1,0},{1,0,1,1,0},{0,1,0,0,0},{0,0,0,0,1}};
        int [][]M = {{1,1,0,0,0},{0,1,0,0,1},{1,0,0,1,1},{0,0,0,0,0},{1,0,1,0,1}};
        System.out.println(Main.largestResult(M));
    }
}
