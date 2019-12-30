package Algorithms.Stacks.replace_each_ele_with_nearest_great_on_right;

/*
Given an array of elements, replace every element with nearest greater element
on the right of that element.
Time Complexity: O(n). Space Complexity: O(n).
*/

import java.util.Stack;

public class Main {
    static void findNearestGreaterElement(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        for(int a : arr) {
            if (stack.isEmpty()) { stack.push(a); }
            else {
                if(a < stack.peek()) { stack.push(a); }
                else {
                    while (!stack.isEmpty() && (a > stack.peek())) {
                        System.out.println("replace : " + stack.pop() + " with : " + a);
                    }
                    stack.push(a);
                }
            }
        }
        while (!stack.isEmpty()) {
            System.out.println("replace : " + stack.pop() + " with : " + "-1");
        }
    }

    public static void main(String[] args) {
        int[] arr = {5,3,2,10,6,8,1,4,12,7,4};
        findNearestGreaterElement(arr);
    }
}
