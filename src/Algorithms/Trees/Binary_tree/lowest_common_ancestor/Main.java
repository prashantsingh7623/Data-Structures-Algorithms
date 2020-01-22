package Algorithms.Trees.Binary_tree.lowest_common_ancestor;

//Problem-26  Give an algorithm for finding LCA (Least Common Ancestor) of two nodes in a
//Binary Tree.

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
            ptr.left = insert(arr, ptr.left, 2 * i + 1);
            ptr.right = insert(arr, ptr.right, 2 * i + 2);
        }
        return ptr;
    }
    static void inOrder() {
        Node ptr = root;
        if (ptr == null) { return; }
        Stack<Node> stack = new Stack<>();
        while (true) {
            while (ptr != null) {
                stack.push(ptr);
                ptr = ptr.left;
            }
            if (stack.isEmpty()) { break; }
            ptr = stack.pop();
            System.out.print(ptr.data + " -> ");
            ptr = ptr.right;
        }
    }
    static Node LCA(Node ptr, Node p, Node q) {
        if (ptr == null) { return null; }
        if (ptr == p || ptr == q) { return ptr; }
        Node _left = LCA(ptr.left, p, q);
        Node _right = LCA(ptr.right, p, q);
        if (_left == null && _right == null) { return null; }
        else if (_left != null && _right != null) { return ptr; }
        return _left != null ? _left : _right;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        root = insert(arr, root, 0);
        inOrder();
        System.out.println();
        Node lca = LCA(root, root.left.left, root.right);
        System.out.println(lca.data);
    }
}
