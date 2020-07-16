package Algorithms.strings.longest_common_subsequence;

//https://www.youtube.com/watch?v=NnD96abizww


/*
Given two strings: string X of length m [X(1..m)], and string Y of length n [Y(1..n)],
find the longest common subsequence: the longest sequence of characters that appear
left-to-right (but not necessarily in a contiguous block) in both strings. For example,
if X = “ABCBDAB” and Y = “BDCABA”, the LCS(X, Y) = {“BCBA”, “BDAB”, “BCAB”}. We can see
there are several optimal solutions.

Time Complexity of the above implementation is O(mn).

For printing the sequence : https://www.geeksforgeeks.org/printing-longest-common-subsequence/
*/

import java.util.Arrays;
public class Main {

    public static int[][] LCSTable;
    public static int LCS(String firstStr, String secStr) {
        char[] str1 = firstStr.toCharArray();
        char[] str2 = secStr.toCharArray();

        int m = str1.length;
        int n= str2.length;

        LCSTable = new int[m+1][n+1];

        for(int i=1; i< LCSTable.length; i++) {
            for (int j=1; j< LCSTable[0].length; j++) {
                if (str1[i-1] == str2[j-1]) {LCSTable[i][j] = LCSTable[i-1][j-1] + 1; }
                else {
                    LCSTable[i][j] = Math.max(LCSTable[i][j-1], LCSTable[i-1][j]);
                }
            }
        }
        return LCSTable[m][n];
    }

    public static String printLCS(String first, String sec) {
        int lenLCS = LCS(first, sec);
        int ind = lenLCS;
        char[] ans = new char[lenLCS];
        for(int i=0; i<LCSTable.length; i++) {
            for(int j=0; j<LCSTable[0].length; j++)
                System.out.print(LCSTable[i][j]);
            System.out.println();
        }
        int i= first.length(), j= sec.length();
        while (i > 0 && j > 0) {
            if (first.charAt(i-1) == sec.charAt(j-1)) {
                ans[ind-1] = first.charAt(i-1);
                i--; j--; ind--;
            }
            else if (LCSTable[i][j-1] < LCSTable[i-1][j]) { i--; }
            else { j--; }
        }

        return Arrays.toString(ans);
    }

    public static void main(String[] args) {
        System.out.println(printLCS("AGGTAB", "GXTXAYB"));
    }
}
