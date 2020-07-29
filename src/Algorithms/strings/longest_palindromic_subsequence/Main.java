package Algorithms.strings.longest_palindromic_subsequence;

// https://www.youtube.com/watch?v=_nCsPn7_OgI&t=197s
public class Main {
  static void LPSubsequence(String str) {
    char[] ch = str.toCharArray();
    int[][] length_arr = new int[ch.length][ch.length];
    for(int i=1; i<ch.length; i++) { length_arr[i][i] = 1; }
    int temp = 1;
    while(temp < ch.length) {
      int i = 0;
      int j = temp;
      while(i < ch.length && j < ch.length) {
        if(ch[i] == ch[j]) { length_arr[i][j] = 2 + length_arr[i+1][j-1]; }
        else { length_arr[i][j] = Math.max(length_arr[i][j-1], length_arr[i+1][j]); }
        i += 1; j += 1;
      }
      temp += 1;
    }

    for(int i=0; i<ch.length; i++) {
      for(int j=0; j<ch.length; j++) {
        System.out.print(length_arr[i][j]);
      }
      System.out.println();
    }

    System.out.println("length is : " + length_arr[0][ch.length-1]);

  }
  public static void main(String[] args) {
    LPSubsequence("adbbcca");
  }
}