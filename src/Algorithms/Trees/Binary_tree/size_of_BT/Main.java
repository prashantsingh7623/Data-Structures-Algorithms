package Algorithms.Trees.Binary_tree.size_of_BT;

/*Problem-6  Give an algorithm for finding the size(total number of nodes) of binary tree.

Solution: Calculate the size of left and right subtrees recursively,
add 1 (current node) and return to its parent.

we can also do it using Level Order Traversal (LOT).
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
    static void insertNodeWithoutRecur(Node ptr, int data) {
        Queue<Node> queue = new LinkedList<>();
        if(ptr == null) { root = new Node(data); return; }
        queue.add(ptr);
        while (!queue.isEmpty()) {
            Node temp = queue.remove();
            if(temp.left != null) { queue.add(temp.left); }
            else { temp.left = new Node(data); return; }
            if(temp.right != null) { queue.add(temp.right); }
            else { temp.right = new Node(data); return; }
        }
    }
    static void preOrderTraversal(Node ptr) {
        Stack<Node> stack = new Stack<>();
        while (true) {
            while (ptr != null) {
                System.out.print(ptr.data + " -> ");
                stack.push(ptr);
                ptr = ptr.left;
            }
            if (stack.isEmpty()) {
                break;
            }
            ptr = stack.pop();
            ptr = ptr.right;
        }
    }
    static int sizeOfBT(Node ptr) {
        if(ptr == null) { return 0; }
        return 1 + sizeOfBT(ptr.left) + sizeOfBT(ptr.right);
    }
    static int sizeOfBTNonRecur(Node ptr) {
        int count = 0;
        if(ptr == null) { return 0; }
        Queue<Node> queue = new LinkedList<>();
        queue.add(ptr);
        while (!queue.isEmpty()) {
            Node temp = queue.remove();
            count++;
            if (temp.left != null) {
                queue.add(temp.left);
            }
            if(temp.right != null) {
                queue.add(temp.right);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        insertNodeWithoutRecur(root, 1); insertNodeWithoutRecur(root, 2);
        insertNodeWithoutRecur(root, 3); insertNodeWithoutRecur(root, 4);
        insertNodeWithoutRecur(root, 5); insertNodeWithoutRecur(root, 6);
        insertNodeWithoutRecur(root, 7);

        preOrderTraversal(root);
        System.out.println();
        System.out.println("size of BT : " + sizeOfBT(root));
        System.out.println("size of BT using Non-recur(LOT) : " + sizeOfBTNonRecur(root));
    }
}

