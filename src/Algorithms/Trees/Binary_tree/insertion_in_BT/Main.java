package Algorithms.Trees.Binary_tree.insertion_in_BT;

/*Problem-5  Give an algorithm for inserting an element into binary tree.

Solution: Since the given tree is a binary tree, we can insert the element wherever we want.
To insert an element, we can use the level order traversal and insert the element wherever
we find the node whose left or right child is NULL.

Here we have 2 methods :
1. using level order : 2 * i + 1 and 2 * i + 2
2. using queue as ADS.
*/

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
    static Node insertNode(Node ptr, int[] arr, int i) {
        if(i < arr.length) {
            ptr = new Node(arr[i]);
            ptr.left = insertNode(ptr.left, arr, 2*i + 1);
            ptr.right = insertNode(ptr.right, arr, 2*i + 2);
        }
        return ptr;
    }
    static void insertNodeUsingQueue(Node ptr, int data) {
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

    static void inOrderTraversalWithoutRecur(Node ptr) {
        Stack<Node> stack = new Stack<>();
        while (true) {
            while (ptr != null) {
                stack.push(ptr);
                ptr = ptr.left;
            }
            if(stack.isEmpty()) { break; }
            ptr = stack.pop();
            System.out.print(ptr.data + " -> ");
            ptr = ptr.right;
        }
    }
    static void insertNodeWithoutRecur(Node ptr, int val) {
        Queue<Node> queue = new LinkedList<>();
        if(ptr == null) { root = new Node(val); return; }
        queue.add(ptr);
        while (!queue.isEmpty()) {
            Node temp = queue.remove();
            if(temp.left != null) { queue.add(temp.left); }
            else { temp.left = new Node(val); return; }
            if(temp.right != null) { queue.add(temp.right); }
            else { temp.right = new Node(val); return; }
        }
    }

    public static void main(String[] args) {
        insertNodeWithoutRecur(root, 1); insertNodeWithoutRecur(root, 2);
        insertNodeWithoutRecur(root, 3); insertNodeWithoutRecur(root, 4);
        inOrderTraversalWithoutRecur(root);
    }
}
