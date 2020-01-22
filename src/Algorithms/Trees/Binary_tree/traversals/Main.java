package Algorithms.Trees.Binary_tree.traversals;

//Node ptr = root; here if root points to different location than ptr will not point to root.

/*like BST we can't insert value in Binary Tree. We insert using level order by making
array of values to be inserted.
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

    static Node insertNode(int[] arr, Node root, int i) {
        if (i < arr.length) {
            root = new Node(arr[i]);

            //insert left and right child
            root.left = insertNode(arr, root.left, 2 * i + 1);
            root.right = insertNode(arr, root.right, 2 * i + 2);
        }
        return root;
    }

    static void preOrder(Node ptr) {
        if (ptr == null) {
            return;
        }
        System.out.print(ptr.data + "- > ");
        preOrder(ptr.left);
        preOrder(ptr.right);
    }
    static void inOrder(Node ptr) {
        if (ptr == null) {
            return;
        }
        inOrder(ptr.left);
        System.out.print(ptr.data + " -> ");
        inOrder(ptr.right);
    }
    static void postOrder(Node ptr) {
        if (ptr == null) {
            return;
        }
        postOrder(ptr.left);
        postOrder(ptr.right);
        System.out.print(ptr.data + " -> ");
    }
    static void levelOrderTraversal(Node ptr) {
        if(ptr == null) { return; }
        Queue<Node> queue = new LinkedList<>();
        queue.add(ptr);
        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            System.out.print(temp.data + " -> ");
            if(temp.left != null) { queue.add(temp.left); }
            if(temp.right != null) { queue.add(temp.right); }
        }
    }

    static void preOrderNonRecursion(Node ptr) {
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
    static void inOrderNonRecursion(Node ptr) {
        Stack<Node> stack = new Stack<>();
        while (true) {
            while (ptr != null) {
                stack.push(ptr);
                ptr = ptr.left;
            }
            if (stack.isEmpty()) {
                break;
            }
            ptr = stack.pop();
            System.out.print(ptr.data + " -> ");
            ptr = ptr.right;
        }
    }
    static void postOrderNonRecursion(Node ptr) {
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
                } else {
                    ptr = ptr.right;
                }
            }
        } while (!stack.isEmpty());
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        Node temp = insertNode(arr, root, 0);
        preOrder(temp);
        System.out.println();
        inOrder(temp);
        System.out.println();
        postOrder(temp);
        System.out.println();
        System.out.print("pre-order using non-recursion : ");
        preOrderNonRecursion(temp);
        System.out.println();
        System.out.print("in-order using non-recursion : ");
        inOrderNonRecursion(temp);
        System.out.println();
        System.out.print("post-order using non-recursion : ");
        postOrderNonRecursion(temp);
        System.out.println();
        System.out.print("level order traversal : ");
        levelOrderTraversal(temp);
    }
}
