package Algorithms.Arrays.boolean_matrix_problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
  public static void main(String[] args) throws IOException {
     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
     StringBuilder sb = new StringBuilder();
     int t = Integer.parseInt(br.readLine());
     while(t > 0) {
      String[] size = br.readLine().split(" ");
      int n = Integer.parseInt(size[0]);
      int m = Integer.parseInt(size[1]);
      int[][] arr = new int[n][m];
      int row[] = new int[n];
      int col[] = new int[m];

      for(int i = 0; i<n; i++) {
        String[] data = br.readLine().split(" ");
        for(int j=0; j<m; j++) {
          arr[i][j] = Integer.parseInt(data[j]);
          if(arr[i][j] == 1) {
            row[i] = 1;
            col[j] = 1;
          }
        }
      }

      // printing using string builder
      for(int i=0; i<n; i++) {
        for(int j=0; j<m; j++) {
          if(row[i] == 1 || col[j] == 1) {
            sb.append(1 + " ");
          } else {
            sb.append(0 + " ");
          }
        }
        sb.append("\n");
      }
      t -= 1;
      System.out.println(sb);
     }
  }
}