package Algorithms.Trees.Binary_search_trees.top_view;

import java.util.*;

class Node {
    int data, hd;
    Node left, right;
    Node(int data) {
        this.data = data;
        this.hd = 0;
        left = right = null;
    }
}

public class Main {
    static Node root = null;
    static void insertNode(int data) { root = _buildTree(root, data); }

    //helper function
    private static Node _buildTree(Node ptr, int data) {
        if (ptr == null) { ptr = new Node(data); return ptr; }
        if (data == ptr.data) {
            System.out.println("duplicate values are not allowed...!");
        }
        if (data < ptr.data) { ptr.left = _buildTree(ptr.left, data); }
        else if (data > ptr.data) { ptr.right = _buildTree(ptr.right, data); }
        return ptr;
    }

    static void preOrder() {
        Node ptr = root;
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

    static void topView() {
        Node ptr = root;
        SortedMap<Integer, Integer> sortedMap = new TreeMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(ptr);
        int h = 0;
        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            h = temp.hd;
            if (!sortedMap.containsKey(h)) { sortedMap.put(h, temp.data); }
            if (temp.left != null) { temp.left.hd = h - 1; queue.add(temp.left); }
            if (temp.right != null) { temp.right.hd = h + 1; queue.add(temp.right); }
        }
        System.out.println(sortedMap.values());
    }

    public static void main(String[] args) {
        insertNode(100); insertNode(200); insertNode(50); insertNode(70);
        insertNode(80); insertNode(90);

        preOrder();
        topView();
    }
}
