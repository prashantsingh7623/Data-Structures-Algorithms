package Algorithms.Trees.Binary_tree.zig_zag_traversal;

/*
* Problem-30  Zigzag Tree Traversal: Give an algorithm to traverse a binary tree in Zigzag
order. For example, the output for the tree below should be: 1 3 2 4 5 6 7

Solution: This problem can be solved easily using two stacks. Assume the two stacks are:
currentLevel and nextLevel. We would also need a variable to keep track of the
current level order (whether it is left to right or right to left).
We pop from currentLevel stack and print the node’s value. Whenever the current level order
is from left to right, push the node’s left child, then its right child, to stack nextLevel.
Since a stack is a Last In First Out (LIFO) structure, the next time that nodes are
popped off nextLevel, it will be in the reverse order.
On the other hand, when the current level order is from right to left,
we would push the node’s right child first, then its left child.
Finally, don’t forget to swap those two stacks at the end of each level
(i. e., when currentLevel is empty).
*/

import java.util.Stack;

class Node {
    int data;
    Node left, right;
    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class Main {
    static Node root = null;
    static Node insertNode(Node ptr, int[] arr, int i) {
        if (i < arr.length) {
            ptr = new Node(arr[i]);

            //insert left and right child
            ptr.left = insertNode(ptr.left, arr, 2 * i + 1);
            ptr.right = insertNode(ptr.right, arr, 2 * i + 2);
        }
        return ptr;
    }
    static void preOrderTraversal() {
        Node ptr = root;
        Stack<Node> stack = new Stack<>();
        while (true) {
            while (ptr != null) {
                System.out.print(ptr.data + " -> ");
                stack.push(ptr);
                ptr = ptr.left;
            }
            if (stack.isEmpty()) {break;}
            ptr = stack.pop();
            ptr = ptr.right;
        }
    }
    static void zigZagTraversal() {
        Node temp = null;
        boolean leftToRight = true; //to change the direction of zig-zag traversal.
        if (root == null) { return; }
        Stack<Node> currStack = new Stack<>(), nextStack = new Stack<>();
        currStack.push(root);
        while (!currStack.isEmpty()) {
            temp = currStack.pop();
            if (temp != null) {
                System.out.print(temp.data + " -> ");
                if (leftToRight) {
                    nextStack.push(temp.left);
                    nextStack.push(temp.right);
                }
                else {
                    nextStack.push(temp.right);
                    nextStack.push(temp.left);
                }
            }
            if (currStack.isEmpty()) {
                leftToRight = !leftToRight;
                Stack<Node> tempStack;
                tempStack = currStack;
                currStack = nextStack;
                nextStack =tempStack;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        root = insertNode(root, arr, 0);
        preOrderTraversal();
        System.out.println();
        zigZagTraversal();
    }
}
