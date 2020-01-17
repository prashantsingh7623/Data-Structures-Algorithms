package Algorithms.Trees.Binary_tree.diameter_of_BT;

/*
* Problem-18  Give an algorithm for finding the diameter of the binary tree.
* The diameter of a tree (sometimes called the width) is the number of nodes on the longest path
* between two leaves in the tree.

* Solution: To find the diameter of a tree, first calculate the diameter of left subtree and
* right subtrees recursively. Among these two values, we need to send maximum value along with
* current level (+1).
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
    static Node root  = null;
    static Node insert(Node ptr, int[] arr, int i) {
        if(i < arr.length) {
            ptr = new Node(arr[i]);
            ptr.left = insert(ptr.left, arr, 2*i + 1);
            ptr.right = insert(ptr.right, arr, 2*i + 2);
        }
        return ptr;
    }
    static void preOrderTraversal(Node ptr) {
        if (ptr == null) { return; }
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
    static int diameterOfBT(Node ptr) {
        if(ptr == null) { return 0; }
        int lHeight = _height(ptr.left);
        int rHeight = _height(ptr.right);
        int lDiameter = diameterOfBT(ptr.left);
        int rDiameter = diameterOfBT(ptr.right);
        return Math.max(1 + lHeight + rHeight, Math.max(lDiameter, rDiameter));
    }
    static int _height(Node ptr) {
        if(ptr == null) { return 0; }
        return 1 + Math.max(_height(ptr.left), _height(ptr.right));
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8};
        Node temp = insert(root, arr, 0);
        preOrderTraversal(temp);
        System.out.println();
        System.out.println("diameter (width) : " + diameterOfBT(temp));
    }
}
