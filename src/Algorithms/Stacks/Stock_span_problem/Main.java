package Algorithms.Stacks.Stock_span_problem;

/*Stock span problem
The Span of a stock price for a given day is defined as the maximum number of consecutive days the
price of the stock is less than or equal to the given day.

Using Brute force method -
Time Complexity: O(n2). Space Complexity: O(1).

Using Linear Time complexity method -
Time Complexity: O(n). Space Complexity: O(n) [for stack].
*/

import java.util.Arrays;
import java.util.Stack;

public class Main {

    //using brute force method.
    static int[] findSpan(int[] a, int n) {
        int[] s = new int[n]; //array for storing span for each day.
        s[0] = 1; //the span for first day is always 1.
        for(int i = 1; i< n; i++) {
            s[i] = 1;
            for(int j = i-1; (j <= i) && (a[i] >= a[j]); j--) { s[i]++; }
        }
        return s;
    }

    //using efficient method (stack ADS)
    static int[] findSpanUsingStack(int[] a, int n) {
        Stack<Integer> stack = new Stack<>();
        int[] s = new int[n];
        s[0] = 1;
        stack.push(0);
        for(int i = 1; i < n; i++) {
            while (!stack.isEmpty() && a[i] > a[stack.peek()]) { stack.pop(); }
            s[i] = (stack.isEmpty() ? (i+1) : i - stack.peek());
            stack.push(i);
//            if(a[stack.peek()] > a[i]) {
//                s[i] = i - stack.peek();
//                stack.push(i);
//            }

        }
        return s;
    }

    public static void main(String[] args) {
        int[] a = {100, 80, 60, 70, 60, 75, 85};

        //using brute force method.
        //System.out.println(Arrays.toString(findSpan(a, a.length)));

        //using efficient approach using stacks.
        System.out.println(Arrays.toString(findSpanUsingStack(a, a.length)));
    }
}
