package Algorithms.Trees.Binary_search_trees.LCA_in_BST;

/*
* Problem-47  Given pointers to two nodes in a binary search tree, find the lowest common
ancestor (LCA). Assume that both values already exist in the tree.
* */

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
    static void insertNode(int data) { root = _buildTree(root, data); }

    private static Node _buildTree(Node ptr, int data) {
        if (ptr == null) { ptr = new Node(data); return ptr; }
        if (data < ptr.data) { ptr.left = _buildTree(ptr.left, data); }
        else if (data > ptr.data) { ptr.right = _buildTree(ptr.right, data); }
        return ptr;
    }

    static void preOrder() {
        Node ptr = root;
        Stack<Node> stack = new Stack<>();
        while (true) {
            while (ptr != null) {
                System.out.print(ptr.data + " -> ");
                stack.push(ptr);
                ptr = ptr.left;
            }
            if (stack.isEmpty()) { break; }
            ptr = stack.pop();
            ptr = ptr.right;
        }
    }

    public static void main(String[] args) {

    }
}
