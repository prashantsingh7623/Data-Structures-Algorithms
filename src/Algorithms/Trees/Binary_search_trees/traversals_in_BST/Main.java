package Algorithms.Trees.Binary_search_trees.traversals_in_BST;

import java.util.*;

class Node {
    int data, hd;
    Node left, right;
    Node(int data) {
        hd = 0;
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

    static void preOrderTraversal(Node ptr) {
        if (ptr == null) { return; }
        System.out.print(ptr.data + " - >");
        preOrderTraversal(ptr.left);
        preOrderTraversal(ptr.right);
    }
    static void inOrderTraversal(Node ptr) {
        if (ptr == null) { return; }
        inOrderTraversal(ptr.left);
        System.out.print(ptr.data + " -> ");
        inOrderTraversal(ptr.right);
    }
    static void postOrderTraversal(Node ptr) {
        if (ptr == null) { return; }
        postOrderTraversal(ptr.left);
        postOrderTraversal(ptr.right);
        System.out.print(ptr.data + " -> ");
        }
    static void preOrderNonRecur() {
        Node ptr = root;
        if (ptr == null) { System.out.print("tree empty...!"); return; }
        Stack<Node> stack = new Stack<>();
        while (true) {
            while (ptr != null) {
                System.out.print(ptr.data + " -> ");
                stack.push(ptr);
                ptr = ptr.left;
            }
            if (stack.isEmpty()) { break; }
            ptr = stack.pop();
            ptr = ptr.right;
        }
    }
    static void inOrderNonRecur() {
        Node ptr = root;
        if (ptr == null) { return; }
        Stack<Node> stack = new Stack<>();
        while (true) {
            while (ptr != null) {
                stack.push(ptr);
                ptr = ptr.left;
            }
            if (stack.isEmpty()) { break; }
            ptr = stack.pop();
            System.out.print(ptr.data + " -> ");
            ptr = ptr.right;
        }
    }
    static void postOrderNonRecur() {
        Node ptr = root;
        if (ptr == null) { return; }
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
    static void levelOrderTraversal() {
        Node ptr = root;
        if (ptr == null) {
            System.out.println("tree is empty...!");
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(ptr);
        while (!queue.isEmpty()) {
            int level = queue.size();
            while (level > 0) {
                Node temp = queue.poll();
                assert temp != null;
                System.out.print(temp.data + " -> ");
                if (temp.left != null) { queue.add(temp.left); }
                if (temp.right != null) { queue.add(temp.right); }
                level--;
            }
            System.out.println();
        }
    }
    static void reverseLevelOrderTraversal() {
        Node ptr = root;
        if (ptr == null) {
            System.out.println("tree is empty...!");
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        queue.add(ptr);
        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            stack.push(temp.data);

            //reverse below lines to change the order of traversals.
            if (temp.left != null) { queue.add(temp.left); }
            if (temp.right != null) { queue.add(temp.right); }
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " -> ");
        }
    }
    static void verticalOrderTraversal() {
        Node ptr = root;
        if (ptr == null) {
            System.out.println("tree is empty...!");
            return;
        }
        ptr.hd = 0;
        SortedMap<Integer, List<Integer>> sortedMap = new TreeMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(ptr);
        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            int hor_d = temp.hd;
            sortedMap.putIfAbsent(hor_d, new ArrayList<>());
            sortedMap.get(hor_d).add(temp.data);
            if (temp.left != null) {
                temp.left.hd = hor_d - 1;
                queue.add(temp.left);
            }
            if (temp.right != null) {
                temp.right.hd = hor_d + 1;
                queue.add(temp.right);
            }
        }
        sortedMap.forEach((key, value) -> System.out.println(key + " : " + value));
    }
    static void zigZagTraversal() {
        Node ptr = root;
        if (ptr == null) {
            System.out.println("tree is empty...!");
            return;
        }

        Stack<Node> curr_stack = new Stack<>(), next_stack = new Stack<>();
        curr_stack.push(ptr);
        boolean left_to_right = true;
        while (!curr_stack.isEmpty()) {
            Node temp = curr_stack.pop();
            if (temp != null) {
                System.out.print(temp.data + " -> ");
                if (left_to_right) {
                    next_stack.push(temp.left);
                    next_stack.push(temp.right);
                }
                else {
                    next_stack.push(temp.right);
                    next_stack.push(temp.left);
                }
            }
            if (curr_stack.isEmpty()) {
                left_to_right = !left_to_right;
                Stack<Node> tempStack;
                tempStack = curr_stack;
                curr_stack = next_stack;
                next_stack = tempStack;
            }
        }
    }


    public static void main(String[] args) {
        insertNode(root, 100); insertNode(root, 200); insertNode(root, 50);
        insertNode(root, 40);insertNode(root, 70);insertNode(root, 150);

        System.out.print("pre-order traversal : ");
        preOrderTraversal(root);
        System.out.print("\nin-order traversal : ");
        inOrderTraversal(root);
        System.out.print("\npost-order traversal : ");
        postOrderTraversal(root);

        System.out.print("\n\npre-order Non-recur : ");
        preOrderNonRecur();
        System.out.print("\nin-order Non-recur : ");
        inOrderNonRecur();
        System.out.print("\npost-order Non-recur : ");
        postOrderNonRecur();

        System.out.println("\nlevel order traversal - ");
        levelOrderTraversal();

        System.out.print("\nreverse levelOrder traversal : ");
        reverseLevelOrderTraversal();

        System.out.println("\nvertical order traversal : ");
        verticalOrderTraversal();

        System.out.println("\nZigZag traversal : ");
        zigZagTraversal();
    }
}
