package Algorithms.Arrays.print_matrix_in_spiral;

public class Main {
    public static void printSpiral(int[][] arr) {
        int rowStart = 0, colStart = 0;
        int rowEnd = arr.length-1, colEnd = arr.length-1;
        while (rowStart <= rowEnd && colStart <= colEnd) {
            int i = rowStart, j = colStart;
            for (j = colStart; j <= colEnd; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
            for (i=rowStart+1, j--; i<=rowEnd; i++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
            for (j=colEnd-1, i--; j>=colStart; j--) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
            for (i=rowEnd-1, j++; i>=rowStart; i--) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
            rowStart++; colStart++; rowEnd--; colEnd--;
        }
    }

    public static void main(String[] args) {
        printSpiral(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}});
    }
}
