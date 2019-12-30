package Algorithms.Stacks.remove_all_adjacent_duplicates;

/*
* Recursively remove all adjacent duplicates:
* Given a string of characters, recursively remove adjacent duplicate characters from string.
* The output string should not have any adjacent duplicates.
* Input: mississippi
* Output: m
* This solution runs with the concept of in-place stack. When element on stack doesn’t match
* the current character, we add it to stack. When it matches to stack top,
* we skip characters until the element matches the top of stack and remove the element from stack.
* Time Complexity: O(n). Space Complexity: O(1) as the stack simulation is done inplace.*/

import java.util.Stack;

public class Main {
    static void removeDuplicates(String s) {
        char[] str = s.toCharArray();
        Stack<Character> stack = new Stack<Character>();
        for(char c : str) {
            if(stack.isEmpty()) { stack.push(c); }
            else {
                if(stack.peek() != c) { stack.push(c); }
                else {
                    while (stack.peek() == c) { stack.pop(); }
                }
            }
        }
        System.out.println(stack);
    }

    public static void main(String[] args) {
        removeDuplicates("mississippi");
    }
}
