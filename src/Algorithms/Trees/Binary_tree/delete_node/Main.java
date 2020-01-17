package Algorithms.Trees.Binary_tree.delete_node;

/*
* Problem-13  Give an algorithm for deleting an element (assuming data is given) from binary
tree.
Solution: The deletion of a node in binary tree can be implemented as
• Starting at root, find the node which we want to delete.
• Find the deepest node in the tree. (using deepest node algorithm)
• Replace the deepest node’s data with node to be deleted.
• Then delete the deepest node.
*
* https://media.geeksforgeeks.org/wp-content/uploads/deletion-in-binary-tree.png
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
    static Node insertNode(Node ptr, int[] arr, int i) {
        if(i < arr.length) {
            ptr = new Node(arr[i]);
            ptr.left = insertNode(ptr.left, arr, 2*i + 1);
            ptr.right = insertNode(ptr.right, arr, 2*i + 2);
        }
        return ptr;
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
    static void deleteNode(Node ptr, int data) {
        //first we find the deepest node.
        if(ptr == null) { return; }
        Queue<Node> queue = new LinkedList<>();
        queue.add(ptr);
        Node temp = null;
        Node data_ptr = null;
        while (!queue.isEmpty()) {
            temp = queue.poll();
            if(temp.data == data) { data_ptr = temp; }
            if(temp.left != null) { queue.add(temp.left); }
            if (temp.right != null) { queue.add(temp.right); }
        }
        assert temp != null; assert data_ptr != null;
        System.out.println("deepest : " + temp.data);
        System.out.println("data : " + data_ptr.data);
        data_ptr.data = temp.data;
        _deleteDeepest(ptr, temp);
    }

    private static void _deleteDeepest(Node ptr, Node temp) {
        if(ptr == null) { return; }
        Queue<Node> queue = new LinkedList<>();
        queue.add(ptr);
        while (!queue.isEmpty()) {
            Node cur_ptr = queue.poll();
            if(cur_ptr == temp) { cur_ptr = null; return; }
            if(cur_ptr.left != null) {
                if (cur_ptr.left == temp) {
                    cur_ptr.left = null; return;
                }
                else {
                    queue.add(cur_ptr.left);
                }
            }
            if (cur_ptr.right != null) {
                if (cur_ptr.right == temp) {
                    cur_ptr.right = null; return;
                }
                else {
                    queue.add(cur_ptr.right);
                }
            }

        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        Node temp = insertNode(root, arr, 0);
        postOrderTraversal(temp);
        System.out.println();
        deleteNode(temp, 5);
        postOrderTraversal(temp);
    }
}
