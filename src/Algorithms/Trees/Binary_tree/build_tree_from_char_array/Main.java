package Algorithms.Trees.Binary_tree.build_tree_from_char_array;

/*
Problem-33  Given a tree with a special property where leaves are represented
with ‘L’ and internal node with ‘I’. Also, assume that each node has either 0 or 2 children.
Given pre-order traversal of this tree, construct the tree.

Example: Given pre-order string => I-L-I-L-L
Solution: First, we should see how pre-order traversal is arranged.
Pre-order traversal means first put root node, then pre-order traversal of left subtree and
then pre-order traversal of right subtree. In a normal scenario, it’s not possible to detect
where left subtree ends and right subtree starts using only pre-order traversal. Since every
node has either 2 children or no child, we can surely say that if a node exists then its sibling
also exists. So every time when we are computing a subtree, we need to compute its sibling subtree
as well.

Secondly, whenever we get ‘L’ in the input string, that is a leaf and we can stop for a
particular subtree at that point. After this ‘L’ node (left child of its parent ‘L’), its
sibling starts. If ‘L’ node is right child of its parent, then we need to go up in the hierarchy
to find the next subtree to compute.

Keeping the above invariant in mind, we can easily determine when a subtree ends and the
next one starts. It means that we can give any start node to our method and it can easily
complete the subtree it generates going outside of its nodes. We just need to take care of
passing the correct start nodes to different sub-trees.
*/

import java.util.Stack;

class Node {
    char data;
    Node left, right;
    Node(char data) {
        this.data = data;
        left = right = null;
    }
}

public class Main {
    static Node root = null;
    static void inOrderTraversal() {
        Node ptr = root;
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
    static void preOrder(Node ptr) {
        if (ptr == null) {
             return;
        }
        System.out.print(ptr.data + " -> ");
        preOrder(ptr.left);
        preOrder(ptr.right);
    }
    static Node buildTree(char[] arr, int i) {
        if (arr == null) { return null; }
        Node ptr = new Node(arr[i]);
        ptr.left = ptr.right = null;
        if (arr[i] == 'L') {
            return ptr;
        }
        i += 1;
        ptr.left = buildTree(arr, i);
        i += 1;
        ptr.right = buildTree(arr, i);
        return ptr;
    }

    public static void main(String[] args) {

        char[] arr = {'I', 'L', 'I', 'L', 'L'};
        root = buildTree(arr, 0);
        preOrder(root);
    }
}
