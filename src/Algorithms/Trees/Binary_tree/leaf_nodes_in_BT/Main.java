package Algorithms.Trees.Binary_tree.leaf_nodes_in_BT;

/*
* Problem-14  Give an algorithm for finding the number of leaves in the binary tree without using recursion.
* Solution: The set of nodes whose both left and right children are NULL are called leaf nodes.
*
* Problem-15  Give an algorithm for finding the number of full nodes in the binary tree without
using recursion.
Solution: The set of all nodes with both left and right children are called full nodes.
*
* Problem-16  Give an algorithm for finding the number of half nodes (nodes with only one
child) in the binary tree without using recursion.
Solution: The set of all nodes with either left or right child (but not both) are called half nodes.
* */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Node {
    int data;
    Node left, right;
    Node(int data) {
        this.data =data;
        left = right = null;
    }
}

public class Main {
    static Node root = null;
    static void insert(Node ptr, int data) {
        if(ptr == null) { root = new Node(data); return; }
        Queue<Node> queue = new LinkedList<>();
        queue.add(ptr);
        while (!queue.isEmpty()) {
            Node temp = queue.remove();
            if (temp.left != null) { queue.add(temp.left); }
            else { temp.left = new Node(data); return; }
            if (temp.right != null) { queue.add(temp.right); }
            else { temp.right = new Node(data); return; }
        }
    }
    static void postOrderTraversal(Node ptr) {
        if (ptr == null) {return;}
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
                }
                else { ptr = ptr.right; }
            }
        } while (!stack.isEmpty());
    }
    static int numberOfLeavesInBT(Node ptr) {
        if (ptr == null) { return 0; }
        Queue<Node> queue = new LinkedList<>();
        queue.add(ptr);
        int count = 0;
        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            if(temp.left == null && temp.right == null) { count++; }
            if (temp.left != null) { queue.add(temp.left); }
            if (temp.right != null) { queue.add(temp.right); }
        }
        return count;
    }

    public static void main(String[] args) {
        insert(root, 1); insert(root, 2);
        insert(root, 3); insert(root, 4);
        //insert(root, 5); insert(root, 6);
        //insert(root, 7);

        postOrderTraversal(root);
        System.out.println();
        System.out.println("number of leaves nodes : " + numberOfLeavesInBT(root));
    }
}
