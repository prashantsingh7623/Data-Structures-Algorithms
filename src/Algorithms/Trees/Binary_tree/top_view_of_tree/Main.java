package Algorithms.Trees.Binary_tree.top_view_of_tree;

/*while finding the top view of the tree, first find the level-order and vertical order traversals
The top element in VOT is considered, if there are more than one element in VOT than LOT is
used to check which element should come first.

ex - LOT [1,2,3,4,5,6,7]
vertical order traversal :
-2 : [4]
-1 : [2]
0 : [5, 1, 6]
1 : [3]
2 : [7]

here [5,1,6] three elements in VOT, so we will consider 1 as it comes before 5 and 6 in LOT.

so Top View of tree = [4,2,1,3,7]
 */

import java.util.*;

class Node {
    int data, hd; //hd for vertical order traversal using non-recursion.
    Node left, right;
    Node(int data)  {
        hd = 0;
        this.data = data;
        left = right = null;
    }
}

public class Main {
    static Node root = null;
    static Node insertNode(Node ptr, int[] arr, int i) {
        if (i < arr.length) {
            ptr = new Node(arr[i]);

            //insert left and right child
            ptr.left = insertNode(ptr.left, arr, 2 * i + 1);
            ptr.right = insertNode(ptr.right, arr, 2 * i + 2);
        }
        return ptr;
    }
    static void inOrderTraversal() {
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
    static Stack<Integer> levelOrderTraversal() {
        Node ptr = root;
        if (ptr == null) { return null; }
        Stack<Integer> stack = new Stack<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(ptr);
        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            stack.push(temp.data);
            if (temp.left != null) { queue.add(temp.left); }
            if (temp.right != null) { queue.add(temp.right); }
        }
        return stack;
    }
    static void _topViewOfTree() {
        if (root == null) {return; }
        int horiz_d = 0;
        Queue<Node> queue = new LinkedList<>();
        SortedMap<Integer, List<Integer>> sortedMap = new TreeMap<>();
        List<Integer> l;
        Stack<Integer> stack = levelOrderTraversal();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            horiz_d = temp.hd;
            if (!sortedMap.containsKey(horiz_d)) {
                l = new ArrayList<>();
                l.add(temp.data);
                sortedMap.put(horiz_d, l);
            } else {
                int val = sortedMap.get(horiz_d).get(0);
                assert stack != null;
                if (stack.indexOf(val) > stack.indexOf(temp.data)) {
                    sortedMap.get(horiz_d).add(0, temp.data);
                } else { sortedMap.get(horiz_d).add(temp.data); }
            }
            if (temp.left != null) { temp.left.hd = horiz_d - 1; queue.add(temp.left); }
            if (temp.right != null) { temp.right.hd = horiz_d + 1; queue.add(temp.right); }
        }
        sortedMap.forEach((key, val) -> System.out.print(val.get(0) + " -> "));
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        root =  insertNode(root, arr, 0);

        System.out.print("top view of tree : ");
        _topViewOfTree();
    }
}
