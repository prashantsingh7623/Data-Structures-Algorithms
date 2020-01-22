package Algorithms.Trees.Binary_tree.print_path_to_leafs;

//Problem-20  Given a binary tree, print out all its root-to-leaf paths.

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
    static void insertNode(int data) {
        Node ptr = root;
        if(ptr == null) { root = new Node(data); return; }
        Queue<Node> queue = new LinkedList<>();
        queue.add(ptr);
        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            if (temp.left != null) { queue.add(temp.left); }
            else { temp.left = new Node(data); return; }
            if (temp.right != null) { queue.add(temp.right); }
            else { temp.right = new Node(data); return; }
        }
    }
    static void postOrder() {
        Node ptr = root;
        if (ptr == null) { System.out.println("tree is empty...!"); return; }
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
                } else { ptr = ptr.right; }
            }
        } while (!stack.isEmpty());
    }
    static void pathToLeafNodes(Node ptr, int[] path, int pathLen) {
        if (ptr == null) { return; }

        //append this node to the path array
        path[pathLen] = ptr.data;
        pathLen ++;

        //it's leaf node, so print the path that led to here
        if (ptr.left == null && ptr.right == null) {
            _printPath(path);
        }
        else {
            pathToLeafNodes(ptr.left, path, pathLen);
            pathToLeafNodes(ptr.right, path, pathLen);
        }
    }

    static void _printPath(int[] path) {
        for (int a : path) {
            System.out.print(a + " -> ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        insertNode(1); insertNode(2); insertNode(3); insertNode(4);
        insertNode(5); insertNode(6); insertNode(7); insertNode(8);

        postOrder();
        System.out.println();
        int[] arr = new int[5];
        pathToLeafNodes(root, arr, 0);
    }
}
