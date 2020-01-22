package Algorithms.Trees.Binary_tree.build_tree_from_pre_in_order;

//Problem-27  Give an algorithm for constructing binary tree from given Inorder and Pre-order
//traversals.

/*
* rootVal = preOrder[0]
* rootInd = 0
* //finding the root element in inorder array
* while(inorder[rootInd] != rootVal) { rootInd ++: }
* ptr.left = buildTree(preOrder[1 : rootInd + 1], inOrder[0 : rootInd])
* ptr.right = buildTree(preOrder[rootInd + 1 : len(preOrder)], inOrder[rootInd + 1, len(preOrder)])
* */

import java.util.Arrays;

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
    static Node buildTree(int[] preOrder, int[] inOrder) {
        if (preOrder.length == 0 && inOrder.length == 0) { return null; }
        Node ptr = new Node(preOrder[0]);
        int rootVal = preOrder[0];
        int rootInd = 0;
        while (inOrder[rootInd] != rootVal) { rootInd ++; }
        ptr.left = buildTree(Arrays.copyOfRange(preOrder, 1, rootInd + 1),
                Arrays.copyOfRange(inOrder, 0, rootInd));
        ptr.right = buildTree(Arrays.copyOfRange(preOrder, rootInd + 1, preOrder.length),
                Arrays.copyOfRange(inOrder, rootInd + 1, inOrder.length));

        return ptr;
    }

    static void preOrderTraversal(Node ptr) {
        if (ptr == null) { return; }
        System.out.print(ptr.data + " -> ");
        preOrderTraversal(ptr.left);
        preOrderTraversal(ptr.right);
    }

    public static void main(String[] args) {
        int[] preOrder = {3, 9, 20, 15, 7};
        int[] inOrder = {9, 3, 15, 20, 7};

        Node temp = buildTree(preOrder, inOrder);
        preOrderTraversal(temp);
    }
}
