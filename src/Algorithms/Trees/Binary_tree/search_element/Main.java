package Algorithms.Trees.Binary_tree.search_element;

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
    static Node insert(int[] arr, Node ptr, int i) {
        if(i < arr.length) {
            ptr = new Node(arr[i]);
            ptr.left = insert(arr, ptr.left, 2*i + 1);
            ptr.right = insert(arr, ptr.right, 2*i +2);
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
                else {
                    ptr = ptr.right;
                }
            }
        } while (!stack.isEmpty());
    }
    static boolean searchUsingRecursion(Node ptr, int ele) {
        if(ptr == null) { return false; }
        else {
            if(ptr.data == ele) { return true;}
            return searchUsingRecursion(ptr.left, ele) || searchUsingRecursion(ptr.right, ele);
        }
    }
    static boolean searchWithoutRecursion(Node ptr, int ele) {
        Queue<Node> queue = new LinkedList<>();
        if(ptr == null) { return false; }
        queue.add(ptr);
        while (!queue.isEmpty()) {
            Node temp = queue.remove();
            if(temp.data == ele) { return true; }
            if(temp.left != null) { queue.add(temp.left); }
            if(temp.right != null) { queue.add(temp.right); }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7 };
        Node temp = insert(arr, root, 0);
        System.out.print("post-order traversal : ");
        postOrderTraversal(temp);
        System.out.println();
        System.out.println("element found using recursion : " + searchUsingRecursion(temp, 1));
        System.out.println("element found without recursion : " + searchWithoutRecursion(temp,1));
    }
}
