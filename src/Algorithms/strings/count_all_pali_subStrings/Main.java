package Algorithms.strings.count_all_pali_subStrings;

public class Main {
  static void countAllPalSubString(String str) {
    int n = str.length();
    boolean[][] arr = new boolean[n][n];
    int count = 0;
    for(int i=0; i<n; i++) {arr[i][i] = true;}
    for(int i=n-2; i>=0; i--) {
        for(int j=i+1; j<n; j++) {
            if(str.charAt(i) == str.charAt(j)) {
                if(arr[i+1][j-1] || j-i == 1) {
                    arr[i][j] = true;
                    count += 1;
                }
            }
        }
      }
      System.out.println("count : " + count);
  }
  public static void main(String[] args) {
    countAllPalSubString("abbaeae");
  }
}