package Algorithms.Trees.Binary_tree.height_of_BT;

/*Problem-10  Give an algorithm for finding the height (or depth) of the binary tree.

Solution: Recursively calculate height of left and right subtrees of a node and assign height to
the node as max of the heights of two children plus 1.
This is similar to PreOrder tree traversal (and DFS of Graph algorithms).

Problem-11  Can we solve Problem-10 without recursion?
Solution: Yes, using level order traversal.
This is similar to BFS of Graph algorithms. End of level is identified with NULL.
*/

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Node {
    int data;
    Node left, right;
    Node(int data) {
        this.data  = data;
        left = right = null;
    }
}

public class Main {
    static Node root = null;
    static void insertNode(Node ptr, int data) {
        if(ptr == null) { root = new Node(data); return; }
        Queue<Node> queue = new LinkedList<>();
        queue.add(ptr);
        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            if (temp.left != null) { queue.add(temp.left); }
            else { temp.left = new Node(data); return; }
            if (temp.right != null) { queue.add(temp.right); }
            else {temp.right = new Node(data); return; }
        }
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
    static int heightOfBinaryTree(Node ptr) {
        if(ptr == null) { return 0; }
        return Math.max(1 + heightOfBinaryTree(ptr.left), 1 + heightOfBinaryTree(ptr.right));
    }
    static int heightOfBinaryTreeWithoutRecur(Node ptr) {
        if(ptr == null) { return 0; }
        int height = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.add(ptr);

        //end of 1st level
        queue.add(null);
        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            if (temp == null) {
                //put another null for next level
                if (!queue.isEmpty()) { queue.add(null); }
                height ++;
            }

            else {
                if(temp.left != null) { queue.add(temp.left); }
                if (temp.right != null) { queue.add(temp.right); }
            }
        }
        return height;
    }

    public static void main(String[] args) {
        insertNode(root, 1); insertNode(root, 2);
        insertNode(root, 3); insertNode(root, 4);
        insertNode(root, 5); insertNode(root, 6);
        insertNode(root, 7); insertNode(root, 8);

        postOrderTraversal(root);
        System.out.println();
        System.out.println("height : " + heightOfBinaryTree(root));
        System.out.println("height using non-recur : " + heightOfBinaryTreeWithoutRecur(root));
    }
}
