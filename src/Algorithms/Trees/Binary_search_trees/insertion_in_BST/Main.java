package Algorithms.Trees.Binary_search_trees.insertion_in_BST;

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
    static void buildTree(int val) { root = _buildTree(root, val); }

    //helper function
    private static Node _buildTree(Node ptr, int data) {
        if (ptr == null) { ptr = new Node(data); return ptr; }
        if (data == ptr.data) {
            System.out.println("duplicate values are not allowed..! : " + ptr.data);
        }
        if (data < ptr.data) { ptr.left = _buildTree(ptr.left, data); }
        else if (data > ptr.data) { ptr.right = _buildTree(ptr.right, data); }
        return ptr;
    }

    static void inOrder(Node ptr) {
        if (ptr == null) { return; }
        inOrder(ptr.left);
        System.out.print(ptr.data + " -> ");
        inOrder(ptr.right);
    }

    public static void main(String[] args) {
        buildTree(100); buildTree(200); buildTree(50); buildTree(30);
        buildTree(70); buildTree(150);

        System.out.println();
        inOrder(root);
    }
}
