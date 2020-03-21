package Algorithms.KMP;

public class Main {
    private void stringSearch(String pat, String txt) {
        int pat_length = pat.length(); //length of the pattern.
        int txt_length = txt.length(); //length of text.

        //make pi table (largest prefix suffix table) that will hold the longest suffix and prefix
        int[] lps = new int[pat_length];
        makeLPS(lps, pat, pat_length);

        int i = 0; // index for text.
        int j = 0; // index for pattern.

        while(i < txt_length) {
            if(txt.charAt(i) == pat.charAt(j)) { i++; j++; }
            if(j == pat_length) {
                System.out.println("string found at : " + (i-j));
                j = lps[j-1];
            }
            else if(i < txt_length && pat.charAt(j) != txt.charAt(i)) {
                if(j != 0) { j = lps[j-1]; }
                else { i++; }
            }
        }
    }
    private void makeLPS(int[] lps, String pat, int pat_length) {
        int i = 0;
        int j = 1;
        lps[0] = 0; //first will always be zero, since there is no string until now.
        while(j < pat_length) {
            if(pat.charAt(i) == pat.charAt(j)) { lps[j] = i+1; i++; j++; }
            else {
                if(i != 0) { i = lps[i-1]; } // important : i becomes value at lps[i-1].
                else { lps[j] = i; j++; }
            }
        }
    }
    public static void main(String[] args) {
        String text = "aabcbcabcdababcd";
        String pattern = "abcd";
        new Main().stringSearch(pattern, text);
    }
}