package Algorithms.Trees.Binary_tree.traversals;

//Node ptr = root; here if root points to different location than ptr will not point to root.

/*like BST we can't insert value in Binary Tree. We insert using level order by making
array of values to be inserted.
*/

import java.util.*;

class Node {
    int data, hd; //hd = horizontal distance for VOT non-recursion.
    Node left, right;

    Node(int data) {
        hd = 0;
        this.data = data;
        left = right = null;
    }
}

public class Main {
    static Node root = null;

    //insertion
    static Node insertNode(int[] arr, Node root, int i) {
        if (i < arr.length) {
            root = new Node(arr[i]);

            //insert left and right child
            root.left = insertNode(arr, root.left, 2 * i + 1);
            root.right = insertNode(arr, root.right, 2 * i + 2);
        }
        return root;
    }

    //traversal using recursion
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
    static void verticalOrderTraversal(Node ptr, int col, Map<Integer, List<Integer>> hashMap) {
        if (ptr == null) { return; }
        verticalOrderTraversal(ptr.left, col - 1, hashMap);
        hashMap.putIfAbsent(col, new ArrayList<>());
        hashMap.get(col).add(ptr.data);
        verticalOrderTraversal(ptr.right, col + 1, hashMap);
    }

    //traversals using non-recursion
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
    static void verticalOrderTraversalNonRecursion(Node root) {
        if (root == null) { return; }
        SortedMap<Integer, List<Integer>> sortedMap = new TreeMap<>();
        Queue<Node> queue = new LinkedList<>();
        List<Integer> l;
        int h_dist = 0;
        queue.add(root);
        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            h_dist = temp.hd;
            if (!sortedMap.containsKey(h_dist)) {
                l = new ArrayList<>();
                l.add(temp.data);
                sortedMap.put(h_dist, l);
            } else {
                sortedMap.get(h_dist).add(temp.data);
            }
            if (temp.left != null) { temp.left.hd = h_dist - 1; queue.add(temp.left); }
            if (temp.right != null) { temp.right.hd = h_dist + 1; queue.add(temp.right); }
        }
        sortedMap.forEach((key, value) -> System.out.println(key + " : " + value));
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 9, 10, 11, 12, 13, 14, 15};
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

        //vertical order traversal
        System.out.println("vertical order traversal : ");
        Map<Integer, List<Integer>> hashMap = new HashMap<>();
        verticalOrderTraversal(temp, 0, hashMap);
        hashMap.forEach((key, value) -> System.out.println(key + " " + value));

        //vertical using non-recursion
        System.out.println();
        System.out.println("vertical using non-recursion : ");
        verticalOrderTraversalNonRecursion(temp);
    }
}
