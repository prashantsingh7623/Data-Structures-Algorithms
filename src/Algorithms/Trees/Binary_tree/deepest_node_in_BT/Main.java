package Algorithms.Trees.Binary_tree.deepest_node_in_BT;

// Problem-12  Give an algorithm for finding the deepest node of the binary tree.

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
    static void insertNode(Node ptr, int data) {
        if (ptr == null) {
            root = new Node(data);
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(ptr);
        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            if (temp.left != null) {
                queue.add(temp.left);
            } else {
                temp.left = new Node(data);
                return;
            }
            if (temp.right != null) {
                queue.add(temp.right);
            } else {
                temp.right = new Node(data);
                return;
            }
        }
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
                if (ptr.right == null || ptr.right == previous) {
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
    static void findDeepestNodeInBT(Node ptr) {
        if(ptr == null) { return; }
        Queue<Node> queue = new LinkedList<>();
        queue.add(ptr);
        Node temp = null;
        while (!queue.isEmpty()) {
            temp = queue.poll();
            if(temp.left != null) { queue.add(temp.left); }
            if (temp.right != null) { queue.add(temp.right); }
        }
        assert temp != null;
        System.out.println("deepest " + temp.data);
    }

    public static void main(String[] args) {
        insertNode(root, 1); insertNode(root, 2);
        insertNode(root, 3); insertNode(root, 4);
        insertNode(root, 5); insertNode(root, 6);
        insertNode(root, 7); insertNode(root, 8);
        postOrderTraversal(root);
        System.out.println();
        findDeepestNodeInBT(root);
    }
}
