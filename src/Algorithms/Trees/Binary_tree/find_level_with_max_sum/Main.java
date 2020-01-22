package Algorithms.Trees.Binary_tree.find_level_with_max_sum;

/*
*Problem-19  Give an algorithm for finding the level that has the maximum sum in the binary
tree.
Solution: The logic is very much similar to finding the number of levels. The only change is, we
need to keep track of the sums as well.
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
    static void insert(int data) {
        Node ptr = root;
        if(ptr == null) { root = new Node(data); return; }
        Queue<Node> queue = new LinkedList<>();
        queue.add(ptr);
        while (!queue.isEmpty()) {
            Node temp = queue.remove();
            if (temp.left != null) { queue.add(temp.left); }
            else { temp.left = new Node(data); return; }
            if (temp.right != null) { queue.add(temp.right); }
            else { temp.right = new Node(data); return; }
        }
    }
    static void postOrderTraversal() {
        Node ptr = root;
        if (ptr == null) { System.out.println("tree is empty...!!");  return; }
        Stack<Node> stack = new Stack<>();
        Node previous = null;
        do {
            while (ptr != null) {
                stack.push(ptr);
                ptr = ptr.left;
            }
            while (ptr == null && !stack.isEmpty()) {
                ptr = stack.peek();
                if(ptr.right == null || ptr.right == previous) {
                    System.out.print(ptr.data + " -> ");
                    stack.pop();
                    previous = ptr;
                    ptr = null;
                }
                else { ptr = ptr.right; }
            }
        } while (!stack.isEmpty());
    }
    static int levelWithMaxSum() {
        Node ptr = root;
        if(ptr == null) {
            System.out.println("tree empty...!");
            return 0;
        }
        int cur_sum = 0;
        int max_sum = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.add(ptr);
        queue.add(null);

        //end of first level
        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            if (temp == null) {

                //put another null for next level
                if(cur_sum > max_sum) { max_sum = cur_sum; cur_sum = 0;}
                if (!queue.isEmpty()) {
                    queue.add(null);
                }
            }
            else {
                cur_sum += temp.data;
                if (temp.left != null) { queue.add(temp.left); }
                if (temp.right != null) { queue.add(temp.right); }
            }
        }
        return max_sum;
    }

    public static void main(String[] args) {
        insert(100); insert(20); insert(30); insert(4); insert(5);
        insert(6); insert(7);

        postOrderTraversal();
        System.out.println();
        System.out.println("max sum : " + levelWithMaxSum());
    }
}
