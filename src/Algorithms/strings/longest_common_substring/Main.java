package Algorithms.strings.longest_common_substring;

/*
The longest common substring problem is to find the longest string (or strings) that is a
substring (or are substrings) of two or more strings.
*/

public class Main {
  static void longestCommonSubstring(String str1, String str2) {
    int[][] length_arr = new int[str1.length() + 1][str2.length() + 1];
    int max = 0;
    for(int i=1; i<str1.length()+1; i++) {
      for(int j=1; j<str2.length()+1; j++) {
        if(str1.charAt(i-1) == str2.charAt(j-1)) {
          length_arr[i][j] = length_arr[i-1][j-1] + 1;
          max = Math.max(max, length_arr[i][j]);
        }
      }
    }
    System.out.println("length of longestCommonSubstring : " + max);
  }

  public static void main(String[] args) {
    longestCommonSubstring("abcdgh", "acdghr");
  }
}
