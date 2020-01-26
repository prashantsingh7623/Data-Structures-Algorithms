package Algorithms.Trees.Binary_tree.ancestors_of_node;

//Problem-29  Give an algorithm for printing all the ancestors of a node in a Binary tree.

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
        if (i  < arr.length) {
            ptr = new Node(arr[i]);
            ptr.left = insertNode(ptr.left, arr, 2*i + 1);
            ptr.right = insertNode(ptr.right, arr, 2*i + 2);
        }
        return ptr;
    }
    static void postOrder() {
        Node ptr = root;
        if (ptr == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        Node previous = null;
        do {
            while (ptr != null) {
                stack.push(ptr);
                ptr = ptr.left;
            }
            while (ptr == null && !stack.isEmpty()) {
                ptr = stack.peek();
                if (ptr.right == null || ptr.right == previous) {
                    System.out.print(ptr.data + " -> ");
                    stack.pop();
                    previous = ptr;
                    ptr = null;
                } else {
                    ptr = ptr.right;
                }
            }
        } while (!stack.isEmpty());
    }
    static boolean printAncestors(Node ptr, Node target) {
        if (ptr != null) {
            if (ptr.data == target.data) {
                return true;
            }
            if (printAncestors(ptr.left, target) || printAncestors(ptr.left, target)) {
                System.out.print(ptr.data + " -> ");
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        root = insertNode(root, arr, 0);
        postOrder();
        System.out.println();
        printAncestors(root, root.left.left);
    }
}
