import java.util.Stack;

class Node {
    int data;
    Node left, right;
    Node(int data) {
        this.data = data;
        this.left = this.right = null;
    }
}

public class Main {
    static Node root = null;
    static void insert(int val) { root = _buildTree(root, val); }

    private static Node _buildTree(Node ptr, int val) {
        if (ptr == null) { ptr = new Node(val); return ptr; }
        if (val < ptr.data) { ptr.left = _buildTree(ptr.left, val); }
        else if (val > ptr.data) { ptr.right = _buildTree(ptr.right, val); }
        return ptr;
    }

    static void postOrder() {
        Node ptr = root;
        if (ptr == null) {
            System.out.println("tree is empty..!");
            return;
        }
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
                    System.out.print(ptr.data + " - >");
                    stack.pop();
                    previous = ptr;
                    ptr = null;
                } else { ptr = ptr.right; }
            }
        } while (!stack.isEmpty());
    }

    public static void main(String[] args) {
        insert(100); insert(200); insert(50);
        Stack<Integer> stack1 = new Stack<>();
        stack1.push(2);
        stack1.push(3);

        Stack<Integer> stack2 = new Stack<>();
        stack2.add(0,1);
        stack2.add(0,2);

        System.out.println(stack2);
    }
}