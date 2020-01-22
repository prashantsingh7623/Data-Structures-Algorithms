package Algorithms.Trees.Binary_tree.convert_tree_to_its_mirror;

/*
* Problem-24  Give an algorithm for converting a tree to its mirror.
* Mirror of a tree is another tree with left and right children of all non-leaf nodes interchanged.
* The trees below are mirrors to each other.
*
* */

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
        if (ptr == null) { root = new Node(data); return; }
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
    static void preOrder() {
        Node ptr = root;
        if (ptr == null) {
            System.out.println("tree is empty...!");
            return;
        }
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
    static Node mirrorTree(Node ptr) {
        Node temp = null;
        if (ptr != null) {
            mirrorTree(ptr.left);
            mirrorTree(ptr.right);

            //swap the pointers
            temp = ptr.left;
            ptr.left = ptr.right;
            ptr.right = temp;
        }
        return ptr;
    }

    public static void main(String[] args) {
        insertNode(1); insertNode(2); insertNode(3); insertNode(4);
        insertNode(5); insertNode(6); insertNode(7);

        System.out.println("pre-order : ");
        preOrder();
        System.out.println();
        root = mirrorTree(root);
        System.out.println("pre- order of mirror tree : ");
        preOrder();
    }
}
