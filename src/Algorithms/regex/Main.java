package Algorithms.regex;
//https://www.youtube.com/watch?v=l3hda49XcDE&feature=emb_logo

import java.util.regex.Pattern;

public class Main {
    static boolean isMatch(String reg, String pat) {
        return Pattern.matches(reg, pat);
    }
    static boolean isMatchUsingDynamicProg(String reg, String pat) {
        char[] text = pat.toCharArray();
        char[] pattern = reg.toCharArray();

        //creating 2d array
        boolean[][] arr = new boolean[text.length + 1][pattern.length + 1];

        //filling 0th row and 0th col for patters like a* or a*b* as they can produce ""(empty string)
        arr[0][0] = true;
        for(int i=1; i<arr[0].length; i++) {
            if(pattern[i-1] == '*') { arr[0][i] = arr[0][i-2]; }
        }

        //logic
        for(int i=1; i<arr.length; i++) {
            for (int j=1; j<arr[0].length; j++) {
                if(pattern[j - 1] == '.' || pattern[j-1] == text[i-1]) {
                    arr[i][j] = arr[i-1][j-1];
                } else if(pattern[j-1] == '*') {
                    arr[i][j] = arr[i][j-2];
                    if (pattern[j-2] == '.' || pattern[j-2] == text[i-1]) {
                        arr[i][j] = arr[i][j] | arr[i-1][j];
                    }
                } else {
                    arr[i][j] = false;
                }
            }
        }
        return arr[text.length][pattern.length];
    }
    public static void main(String[] args) {
        System.out.println(isMatchUsingDynamicProg("c*a*b", "aab"));
    }
}
