package Algorithms.Trees.Binary_search_trees.check_BST;

class Node {
  int data;
  Node left, right;
  Node(int data) {
    this.data = data;
    left = right = null;
  }
}

public class Main {
  public static Node root = null;
  static boolean isBST(Node ptr) {
    return _isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }

  static boolean _isBST(Node ptr, int min, int max) {
    if(ptr == null) { return true; }
    if (ptr.data < min || ptr.data > max) { return false; }
    return _isBST(ptr.left, min, ptr.data - 1) && _isBST(ptr.right, ptr.data+1, max);
  }

  public static void main(String[] args) {
    root = new Node(10);
    root.left = new Node(9);
    root.right = new Node(11);

    if(isBST(root)) { System.out.println("true");}
    else { System.out.println("false");}
  }
}