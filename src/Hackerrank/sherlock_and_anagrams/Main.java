package Hackerrank.sherlock_and_anagrams;

/*
here we have to find the anagrams of the given string.
The method we follow here is to calculate all the anagrams using binomial coefficient formula.
that is n(n-1) / 2.
Here first we find all the possible sorted pairs of length 1,2,..size of string.
and than we find possible anagrams using the above formula.
Finally we return the total count.

ex - 'abba'
Here possible string are - ['a','b','b','a'] : of length 1.
So, here 'a' comes 2 times - using formula we get - 1 anagram.
same with 'b' - we get 1 anagram.

now for strings of length 2 - ['ab','bb','ba']
but in our case we are sorting the pairs so it becomes ['ab', 'bb' ,'ab']
here, ab occurs 2 times, so using the formula we get - 1 anagram
and no anagram for 'bb'.

This is how we'll find all the possible anagrams and return the count.

In java we use maps to store the occurrences of substrings.
* */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    static int countAnagrams(String anagram) {

        //initialising the stuff
        int count = 0;
        Map<String, Integer> map = new HashMap<>();
        String str = null;

        //loop through the string
        for (int i=0; i<anagram.length(); i++) {
            str = "";

            //to find substrings
            for (int j = i+1; j<anagram.length() + 1; j++) {
                str = anagram.substring(i, j);
                char[] temp = str.toCharArray(); //converting the sub-string into char array
                Arrays.sort(temp); // sorting the char array
                str = String.copyValueOf(temp); // again converting char array into string
                if (!map.containsKey(str)) { map.put(str, 1); }
                else { map.replace(str, map.get(str) + 1); }
            }
        }

        //finding the possible anagrams using the formula.
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
            count += (entry.getValue() * (entry.getValue() - 1)) / 2;
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(countAnagrams("kkkk"));
    }
}
