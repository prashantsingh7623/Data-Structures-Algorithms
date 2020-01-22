package Algorithms.Trees.Binary_tree.check_2_trees_are_mirror;

//Problem-25  Given two trees, give an algorithm for checking whether they are mirrors of
//each other.

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
    Node root = null;
    void insert(int data) {
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
    void preOrder() {
        Node ptr = root;
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
    static boolean isMirror(Node root1, Node root2) {
        if(root1 == null && root2 == null) { return true; }
        if (root1 == null || root2 == null) { return false; }
        return isMirror(root1.left, root2.right) && isMirror(root1.right, root2.left);
    }


    public static void main(String[] args) {
        Main tree1 = new Main();
        tree1.insert(1); tree1.insert(2); tree1.insert(3);
        tree1.insert(4); tree1.insert(5); tree1.insert(6);
        tree1.insert(7);

        Main tree2 = new Main();
        tree2.insert(1); tree2.insert(3); tree2.insert(2); tree2.insert(7);
        tree2.insert(6); tree2.insert(5); tree2.insert(4);

        tree1.preOrder();
        System.out.println();
        tree2.preOrder();
        System.out.println();
        System.out.println("is mirror : " + isMirror(tree1.root, tree2.root));
    }
}
