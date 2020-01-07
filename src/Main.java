//find largest island in 2d matrix or number of 1's in an matrix.
public class Main {
    static int ROW, COL, count;

    //function to check whether the cell(i,j) is safe to explore.
    static boolean isSafe(int row, int col, int[][] M, boolean[][] visited) {
        return ((row >= 0) && (row < ROW) && (col >=0 ) && (col < COL)
                && M[row][col] == 1 && !visited[row][col]);
    }

    //method explore cell(i,j)
    static void DFS(int row, int col, int[][] M, boolean[][] visited) {
        //mark this cell as visited
        visited[row][col] = true;

        //make array to store cell indexes which help to explore.
        int[] rowNbr = {-1,-1,-1,0,0,1,1,1};
        int[] colNbr = {-1,0,1,-1,1,-1,0,1};

        for(int i = 0; i<7; i++) {
            if(isSafe(row + rowNbr[i], col + colNbr[i], M, visited)) {
                count ++;
                DFS(row + rowNbr[i], col + colNbr[i], M, visited);
            }
        }
    }

    //method to find largest island.
    static int largestIsland(int[][] M) {
        boolean[][] visited = new boolean[ROW][COL];
        int largest = 0;
        for(int i=0; i<ROW; i++)
            for(int j=0; j<COL; j++) {
                if(M[i][j] == 1 && !visited[i][j]) {
                    count = 1;
                    DFS(i,j,M,visited);
                    largest = Math.max(largest, count);
                }
            }
        return largest;
    }

    public static void main(String[] args) {
        ROW = 5;
        COL = 5;
        int [][]M = {{1,1,0,0,0},{0,1,0,0,1},{1,0,0,1,1},{0,0,0,0,0},{1,0,1,0,1}};
        System.out.println(largestIsland(M));
    }
}
