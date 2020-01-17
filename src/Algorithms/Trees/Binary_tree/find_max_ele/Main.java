package Algorithms.Trees.Binary_tree.find_max_ele;

/*
Problem-3  Give an algorithm for searching an element in binary tree.

Solution: Given a binary tree, return true if a node with data is found in the tree.
Recurse down the tree, choose the left or right branch by comparing data with each node’s data.
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
    static int max = 0;
    static Node insert(Node ptr, int[] arr, int i) {
        if(i < arr.length) {
            ptr = new Node(arr[i]);
            ptr.left = insert(ptr.left, arr, 2*i + 1);
            ptr.right = insert(ptr.right, arr, 2*i + 2);
        }
        return ptr;
    }
    static void postOrderTraversal(Node ptr) {
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
    static int findMax(Node ptr) {
        if(ptr == null) { return 0; }
        if(ptr.data > max) { max = ptr.data; }
        findMax(ptr.left);
        findMax(ptr.right);
        return max;
    }
    static int findMaxWithoutRecursionUsingStack(Node ptr) {
        int max = 0;
        Stack<Node> stack = new Stack<>();
        while(true) {
            while (ptr != null) {
                stack.push(ptr);
                ptr = ptr.left;
            }
            if(stack.isEmpty()) { break; }
            ptr = stack.pop();
            if(ptr.data > max) { max = ptr.data; }
            ptr = ptr.right;
        }
        return max;
    }
    static int findMaxWithoutRecursionUsingQueue(Node ptr) {
        int max = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.add(ptr);
        while (!queue.isEmpty()) {
            Node temp = queue.remove();
            if(temp.data > max) { max = temp.data; }
            if(temp.left != null) { queue.add(temp.left); }
            if(temp.right != null) { queue.add(temp.right); }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {10,2,3,40,5,60,7};
        Node temp = insert(root, arr, 0);
        System.out.print("post order traversal : ");
        postOrderTraversal(temp);
        System.out.println();
        System.out.println("max with recursion : " + findMax(temp));
        System.out.println("max without recursion using stack: " + findMaxWithoutRecursionUsingStack(temp));
        System.out.println("max without recursion using queue : " + findMaxWithoutRecursionUsingQueue(temp));
    }
}
