package Algorithms.strings.longest_palindromic_substring;

//https://leetcode.com/problems/longest-palindromic-substring/solution/

import java.util.Arrays;
import java.util.stream.IntStream;

public class Main {
    static void longestPalindromicSubstring(String s) {

        //converting string into new char array with # as spaces to handle even length cases.
        int ind = 0;
        char[] s_toChar = s.toCharArray();
        char[] str = new char[2 * s.length() + 3];
        str[0] = '@'; str[str.length - 1] = '&';
        for(int i=1; i<str.length-1; i++) {
            if(i%2 == 0) { str[i] = s_toChar[ind++]; }
            else { str[i] = '#'; }
        }
        System.out.println(str);

        //making temporary array
        int[] temp = new int[str.length];

        // logic
        int mirror = 0, r = 0, c = 0, max = 0;
        for(int i=1; i<str.length-1; i++) {
            mirror = 2*c - i;

            //if palindrome is contained inside current palindrome
            if(i < r) {
                temp[i] = Math.min(r - i, temp[mirror]);
            }
            while(str[i + (1 + temp[i])] == str[i - (1 + temp[i])]) {
                temp[i] += 1;
            }
            // if palindrome expands to right end
            if(i + temp[i] > r) {
                c = i;
                r = i + temp[i];
            }
            if (temp[i] > max) { max = temp[i]; }
        }

        System.out.println("temp : " + Arrays.toString(temp));
        System.out.println("max :" +  max);
        final int v = max;
        int index = IntStream.range(0, temp.length)
                        .filter(i -> v == temp[i])
                        .findFirst()
                        .orElse(-1);

        System.out.println("index of : " + max + " is : " + index);
        System.out.println(s);
        int center = ((index / 2) - 1);
        System.out.println("center is : " + center);
        int mid = Math.floorDiv(max, 2);

        //for even and odd length palindrome
        if(max % 2 == 0) {
            System.out.println("longest palindromic string is : " +
                    s.substring(center-mid + 1, center + mid + 1));
        } else {
            System.out.println("longest palindromic string is : " +
                    s.substring(center-mid, center + mid + 1));
        }
    }

    public static void main(String[] args) {
        longestPalindromicSubstring("ac");
    }
}
