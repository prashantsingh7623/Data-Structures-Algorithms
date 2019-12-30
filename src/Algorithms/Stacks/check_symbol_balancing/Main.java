package Algorithms.Stacks.check_symbol_balancing;

/*Stacks can be used to check whether the given expression has balanced symbols.
This algorithm is very useful in compilers. Each time the parser reads one character at a time.
If the character is an opening delimiter such as (, {, or [- then it is written to the stack.
When a closing delimiter is encountered like ), }, or ]-the stack is popped.
The opening and closing delimiters are then compared. If they match, the parsing of the string continues.
If they do not match, the parser indicates that there is an error on the line.

Time complexity : O(n)
*/

import javax.print.DocFlavor;
import java.util.Stack;

public class Main {
    static String checkBalance(String str) {
        Stack<Character> stack = new Stack<Character>();
        for (char ch : str.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{') { stack.push(ch); }
            else {
                if (ch == ')') {
                    if (!stack.isEmpty()) {
                        char temp = stack.pop();
                        if (temp != '(') { return "NO"; }
                    } else { return "NO"; }

                } else if (ch == ']') {
                    if (!stack.isEmpty()) {
                        char temp = stack.pop();
                        if (temp != '[') { return "NO"; }
                    } else { return "NO"; }

                } else if (ch == '}') {
                    if (!stack.isEmpty()) {
                        char temp = stack.pop();
                        if (temp != '{') { return "NO"; }
                    } else { return "NO"; }
                }
            }
        }
        if(stack.isEmpty()) { return "YES"; }
        else { return "NO"; }
    }

    public static void main(String[] args) {
        String str = null;
        System.out.print("Enter the expression : ");
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        str = scanner.nextLine();
        String s = checkBalance(str);
        System.out.println(s);
    }
}
