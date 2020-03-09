package Algorithms.Trees.Binary_search_trees.search_ele;

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
        if (ptr == null) { root = new Node(data); return; }
        if (data < ptr.data) {
            if (ptr.left != null) { insertNode(ptr.left, data); }
            else { ptr.left = new Node(data); }
        }
        else if (data > ptr.data) {
            if (ptr.right != null) { insertNode(ptr.right, data); }
            else { ptr.right = new Node(data); }
        }
    }
    static void inOrder() {
        Node ptr = root;
        if (ptr == null) {
            System.out.println("tree is empty...!");
            return;
        }

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
    static void searchElement(int val) {
        Node ptr = root;
        if (ptr == null) {
            System.out.println("tree is empty...!");
            return;
        }
        while (ptr != null) {
            if (val == ptr.data) {
                System.out.println("element : " + val + " found");
                return;
            }
            else if (val < ptr.data) { ptr = ptr.left; }
            else { ptr = ptr.right; }
        }
        System.out.println("element not in tree");
    }
    static boolean searchElementNonRecur(Node ptr, int val) {
        if (ptr == null) { return false; }
        if (val < ptr.data) { return searchElementNonRecur(ptr.left, val); }
        else if (val > ptr.data) { return searchElementNonRecur(ptr.right, val); }
        return true;
    }

    public static void main(String[] args) {
        insertNode(root, 100); insertNode(root, 200); insertNode(root, 50);
        insertNode(root, 40); insertNode(root, 70); insertNode(root, 150);
        insertNode(root, 250);

        System.out.print("inorder : ");
        inOrder();
        System.out.println();
//        searchElement(150);
        System.out.println(searchElementNonRecur(root, 100));
    }
}
