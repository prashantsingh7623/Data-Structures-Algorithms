package Algorithms.Trees.Binary_tree.print_reverse_LOT;

/*Problem-8  Give an algorithm for printing the level order data in reverse order. For example,
the output for the below tree should be: 4 5 6 7 2 3 1
*/

import java.util.LinkedList;
import java.util.Queue;
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
    static void insertNodeNonRecur(Node ptr, int data) {
        if(ptr == null) {
            root = new Node(data);
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(ptr);
        while (!queue.isEmpty()) {
            Node temp = queue.remove();
            if(temp.left != null) { queue.add(temp.left); }
            else { temp.left = new Node(data); return; }
            if (temp.right != null) { queue.add(temp.right); }
            else { temp.right = new Node(data); return; }
        }
    }
    static void postOrderTraversalNonRecur(Node ptr) {
        if(ptr == null) { return; }
        Stack<Node> stack = new Stack<>();
        Node previous = null;
        do {
            while (ptr != null) {
                stack.push(ptr);
                ptr = ptr.left;
            }
            while (ptr == null && !stack.isEmpty()) {
                ptr = stack.peek();
                if(ptr.right == null || ptr.right == previous) {
                    System.out.print(ptr.data + " -> ");
                    stack.pop();
                    previous = ptr;
                    ptr = null;
                }
                else { ptr = ptr.right; }
            }
        } while (!stack.isEmpty());
    }
    static void reverseOrderTraversal(Node ptr) {
        if(ptr == null) { return; }
        Queue<Node> queue = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        queue.add(ptr);
        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            stack.push(temp.data);
            if (temp.right != null) { queue.add(temp.right); } //changing the order of if statements
            if(temp.left != null) { queue.add(temp.left); } //will effect the print order
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " -> ");
        }
    }

    public static void main(String[] args) {
        insertNodeNonRecur(root, 1);insertNodeNonRecur(root, 2);
        insertNodeNonRecur(root, 3);insertNodeNonRecur(root, 4);
        insertNodeNonRecur(root, 5);insertNodeNonRecur(root, 6);
        insertNodeNonRecur(root, 7);

        System.out.print("post-order traversal : "); postOrderTraversalNonRecur(root);
        System.out.println();
        reverseOrderTraversal(root);
    }
}
