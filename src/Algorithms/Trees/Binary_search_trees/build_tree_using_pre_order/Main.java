package Algorithms.Trees.Binary_search_trees.build_tree_using_pre_order;

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
  static void buildBST(int[] arr) {
    for (int i=arr.length-1; i>=0; i--)
      root = _buildTree(root, arr[i]);
  }

  static Node _buildTree(Node ptr, int data) {
    if(ptr == null) { ptr = new Node(data); return ptr;}
    if(data < ptr.data) { ptr.left = _buildTree(ptr.left, data); }
    else if(data > ptr.data) { ptr.right = _buildTree(ptr.right, data); }
    return ptr;
  }

  static void preOrder(Node ptr) {
    if(ptr == null) return;
    System.out.print(ptr.data + " ");
    preOrder(ptr.left);
    preOrder(ptr.right);
  }

  static void inOrder(Node ptr) {
    if(ptr == null) return;
    inOrder(ptr.left);
    System.out.print(ptr.data + " ");
    inOrder(ptr.right);
  }

  static void postOrder(Node ptr) {
    if(ptr == null) return;
    postOrder(ptr.left);
    postOrder(ptr.right);
    System.out.print(ptr.data + " ");
  }

  

  public static void main(String[] args) {
    // int[] arr = {10, 5, 1, 7, 40, 50};
    int[] arr = {1, 7, 5, 50, 40 ,10};
    buildBST(arr);
    preOrder(root);
    System.out.println();
    inOrder(root);
    System.out.println();
    postOrder(root);
  }
}
