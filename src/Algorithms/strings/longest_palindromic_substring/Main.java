package Algorithms.strings.longest_palindromic_substring;

//https://leetcode.com/problems/longest-palindromic-substring/solution/
// https://www.youtube.com/watch?v=nbTSfrEfo6M&t=928s

import java.util.Arrays;
import java.util.stream.IntStream;

public class Main {
  public static void LPSubstring(String str) {
    // converting to char array to deal with even and odd length cases
    char[] str_char = str.toCharArray();

    // inserting special symbols like # between characters and @ at start and & at end
    char[] ch = new char[2 * str_char.length + 3];
    ch[0] = '@'; ch[ch.length - 1] = '$';
    int ind = 0; // for interating over str_char
    for(int i=1; i<ch.length-1; i++) {
      if(i % 2 != 0) { ch[i] = '#'; }
      else { ch[i] = str_char[ind++]; }
    }

    // logic
    // declaring mirror, right_end, center
    int mirror = 0, right_end = 0, center = 0, maxLength = 0;
    int[] pal_length_arr = new int[ch.length]; // array to store lengths

    // looping over the newly created char array
    for(int i=1; i<ch.length-1; i++) { // here i represent palindrome length at pal_length_arr[i]
      mirror = 2 * center - i; // center = (mirror + i) / 2, we have to find mirror for every i
      if(i < right_end) { pal_length_arr[i] = Math.min(right_end - i, pal_length_arr[mirror]); }

      // its time to check and expand
      while(ch[i + (1 + pal_length_arr[i])] == ch[i - (1 + pal_length_arr[i])]) { // here we are actually saving time, understand it
        pal_length_arr[i]++;
      }

      // if we expand, check if we expand beyond right, than we have to shift center and right end
      if(i + pal_length_arr[i] > right_end) {
        center = i;
        right_end = i + pal_length_arr[i];
      }

      maxLength = Math.max(maxLength, pal_length_arr[i]);
    }

    // finding the center where the palindrome has max length, which is stored in pal_length_arr
    int max = maxLength;
    int index = IntStream.range(0, pal_length_arr.length)
      .filter(i -> max == pal_length_arr[i])
      .findFirst()
      .orElse(-1);

    int center_str = (index / 2) -1;
    int mid_str = Math.floorDiv(maxLength, 2);

    if(maxLength % 2 == 0) { System.out.println(str.substring(center_str - mid_str + 1, center_str + mid_str + 1)); }
    else { System.out.println(str.substring(center_str - mid_str, center_str + mid_str + 1)); }
    for(int i:pal_length_arr)
      System.out.print(i + " ");
  }
  public static void main (String[] args) {
    LPSubstring("bcacbf");
  }
}
