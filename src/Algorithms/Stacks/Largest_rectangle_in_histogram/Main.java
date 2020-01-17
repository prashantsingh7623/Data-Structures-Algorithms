package Algorithms.Stacks.Largest_rectangle_in_histogram;

/*
Largest rectangle under histogram:
A histogram is a polygon composed of a sequence of rectangles aligned at a common base line.
For simplicity, assume that the rectangles have equal widths but may have different heights.
For example, the figure on the left shows a histogram that consists of rectangles
with the heights 3,2,5,6,1,4,4, measured in units where 1 is the width of the rectangles.
Here our problem is: given an array with heights of rectangles (assuming width is 1),
we need to find the largest rectangle possible

approach 1 : Brute force
suppose arr = {1,2,3,4,5,3,3,2}, at instance i'm at 3, than i'll look for smaller or equal to 3 value at
left or right. So there are 5 bars of height 3, including left and right of 3.
Therefore area = 5 * 3 = 15.
Time complexity = O(n2)

approach 2 : using stack as ADS
we use the stacks to keep the track of heights.
Time complexity :
At the first impression, this solution seems to be having O(n2) complexity.
But if we look carefully, every element is pushed and popped at most once,
and in every step of the function at least one element is pushed or popped.
Since the amount of work for the decisions and the update is constant,
the complexity of the algorithm is O(n) by amortized analysis. Space Complexity: O(n) [for stack].
*/

import java.util.Stack;

public class Main {
    static Stack<Integer> stack = new Stack<>();
    static int findLargestRectangle_STACK(int[] a) {
        int area = 0, maxArea = 0, temp = 0, i = 0;
        int n = a.length;
        while (i < n){
            if(stack.isEmpty() || a[i] >= a[stack.peek()]) { stack.push(i); i ++;}
            else {
                temp = stack.pop();
                area = a[temp] * (stack.isEmpty() ? i : (i-1-stack.peek()));
                System.out.println("area : " + area);
                if(area > maxArea) { maxArea = area; }
            }
        }
        while (!stack.isEmpty()) {
            temp = stack.pop();
            area = a[temp] * (stack.isEmpty() ? i : (i - 1 - stack.peek()));
            System.out.println("area 2 : " + area);
            if(area > maxArea) { maxArea = area; }
        }
        return maxArea;
    }
    static int findLargestRectangle_BruteForce(int[] a) {
        int n = a.length;
        int max, greatMax = 0;
        for (int value : a) {
            max = 0;
            for (int i : a) {
                if (i >= value) {
                    max = max + value;
                }
            }
            if (max > greatMax) {
                greatMax = max;
            }
        }
        return greatMax;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,3,3,2};
        //int[] arr = {20,2,3,4,2,10};
        //int[] arr = {1,2,3};
        System.out.println("max : " + findLargestRectangle_STACK(arr));
    }
}
