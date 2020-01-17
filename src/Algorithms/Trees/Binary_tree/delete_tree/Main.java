package Algorithms.Trees.Binary_tree.delete_tree;


/*Problem-9  Give an algorithm for deleting the tree.
*
Solution - To delete a tree, we must traverse all the nodes of the tree and delete them one by one.
So which traversal should we use: Inorder, Preorder, Postorder or Level order Traversal?
Before deleting the parent node we should delete its children nodes first.
We can use postorder traversal as it does the work without storing anything.
We can delete tree with other traversals also with extra space complexity.
For the following, tree nodes are deleted in order – 4,5,2,3,1.
* */


import java.util.Stack;

class Node {
    int data;
    Node left, right;
    Node(int data){
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
    static void deleteTree(Node ptr) {
        if(ptr == null) { return; }
        deleteTree(ptr.left);
        deleteTree(ptr.right);
        ptr = null;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        Node temp = insertNode(root, arr, 0);
        postOrderTraversal(temp);
        deleteTree(temp);
        System.out.println(temp);
    }
}
