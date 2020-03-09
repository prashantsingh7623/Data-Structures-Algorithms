package Algorithms.Trees.Binary_search_trees.min_and_max_element;

/*
* In BSTs, the minimum element is the left-most node, which does not has left child.
* In BSTs, the maximum element is the right-most node, which does not have right child
* */

class Node {
    int data;
    Node left, right;
    Node(int data) {
        this.data = data;
        this.left = this.right = null;
    }
}

public class Main {
    static Node root = null;
    static void insert(int data) { root = _buildTree(root, data); }

    //helper function
    private static Node _buildTree(Node ptr, int val) {
        if (ptr == null) { ptr = new Node(val); return ptr; }
        if (val < ptr.data) { ptr.left = _buildTree(ptr.left, val); }
        else if (val > ptr.data) { ptr.right = _buildTree(ptr.right, val); }
        return ptr;
    }

    static void preOrder(Node ptr) {
        if (ptr == null) { return; }
        System.out.print(ptr.data + " -> ");
        preOrder(ptr.left);
        preOrder(ptr.right);
    }

    static int minElement(Node ptr) {
        if (ptr == null) { return 0; }
        else if (ptr.left == null) { return ptr.data; }
        else { return minElement(ptr.left); }
    }
    static int minElementNonRecur() {
        Node ptr = root;
        while (ptr.left != null) { ptr = ptr.left; }
        return ptr.data;
    }

    static int maxElement(Node ptr) {
        if (ptr == null) { return 0; }
        else if (ptr.right == null) { return ptr.data; }
        else { return maxElement(ptr.right); }
    }
    static int maxElementNonRecur() {
        Node ptr = root;
        while (ptr.right != null) { ptr = ptr.right; }
        return ptr.data;
    }


    public static void main(String[] args) {
        insert(100); insert(200); insert(50);
        insert(40); insert(70); insert(150);
        insert(250);

        preOrder(root);
        System.out.println("\n"+minElement(root));
        System.out.println("\n"+minElementNonRecur());
        System.out.println("\n"+maxElement(root));
        System.out.println("\n"+maxElementNonRecur());
    }
}
