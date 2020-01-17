package Algorithms.Trees;

import java.util.*;

class Node {
    int data,horiz_dist;
    Node left, right;
    Node(int item) {
        horiz_dist = 0;
        data = item;
        left = right = null;
    }
}
public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static Queue<Node> queue;
    private static Stack<Integer> stack;

    private Node root;
    private Main() {
        root = null;
    }

    private void insert(int val) {
        root = _insert(root,val);
    }
    private void search() {
        System.out.println("Enter the value to search : ");
        int data = scanner.nextInt();
        Node search_ptr = _search(root,data);
        if(search_ptr == null) {
            System.out.println("data item not found...! ");
        } else {
            System.out.println("data item found :) " + search_ptr.data);
        }
    }
    private void deleteNode() {
        System.out.print("Enter the practice.BinarySearchTree.Node to delete : ");
        int item = scanner.nextInt();
        Node node = _delete(root, item);
        System.out.print("item deleted successfully : ");
        _preOrder(node);
    }
    private void minKey() {
        Node n = _minKeyInBST(root);
        if(n == null) {
            System.out.println("tree is empty...!");
        } else {
            System.out.println("minimum key is : " + n.data);
        }
    }
    private void maxKey() {
        Node n = _maxKeyInBST(root);
        if(n == null) {
            System.out.println("tree is empty...!");
        } else {
            System.out.println("maximum key is : " + n.data);
        }
    }
    private void preOrderTraversal() { _preOrder(root); }
    private void postOrderTraversal() { _postOrder(root); }
    private void inOrderTraversal() { _inOrder(root); }
    private void levelOrderTraversal() { _levelOrderTraversal(root); }
    private void reverseOrderTraversal() { _reverseLevelOrderTraversal(root); }
    private void verticalOrderTraversal() { _verticalOrderTraversal(root); }
    private void topViewOfTree() { _topView(root); }
    private void heightOfTree() {
        int height = _heightOfTree(root);
        System.out.println("height of tree is : " + height); }
    private void diagonalElements() { _diagonalElements(root); }
    private void diameterOfTree() {
        int result = _diameter(root);
        System.out.println("diameter is : " + result);}
    private void ancestorsOfNode() {
        System.out.println("enter the key to find ancestors : ");
        int k = scanner.nextInt();
        Node key_ref = _search(root, k);
        _ancestorsOfNode(root, key_ref);
    }
    private void lowestCommonAncestorOfNode() {
        System.out.println("Enter the 2 keys to find lowest common ancestor : ");
        int k1 = scanner.nextInt();
        int k2 = scanner.nextInt();
        Node ref_k1 = _search(root, k1);
        Node ref_k2 = _search(root, k2);
        Node lca = _lowestCommonAncestor(root, ref_k1, ref_k2);
        if(lca == null) {
            System.out.println("tree is empty...!");
        } else {
            System.out.println("lowest common ancestor is : " + lca.data);
        }
    }
    private void checkBST() {
        boolean result = _checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        System.out.println("the result is : " + result);
    }

    private Node _insert(Node cur_ptr, int val) {
        if(cur_ptr == null) { cur_ptr = new Node(val); return cur_ptr; }
        if(val == cur_ptr.data) {
            System.out.println("duplicate values are not allowed...! " + cur_ptr.data);
        }
        if(val < cur_ptr.data) { cur_ptr.left = _insert(cur_ptr.left, val); }
        else if(val > cur_ptr.data) { cur_ptr.right = _insert(cur_ptr.right, val); }
        return cur_ptr;
    }
    private Node _search(Node cur_ptr, int data) {
        if(cur_ptr == null) { return cur_ptr; }
        if(cur_ptr.data == data) { return cur_ptr; }
        else if(data > cur_ptr.data) { return  _search(cur_ptr.right, data); }
        else { return _search(cur_ptr.left,data); }
    }
    private Node _delete(Node cur_ptr, int val) {
        if(cur_ptr == null) { return cur_ptr;}
        if(val < cur_ptr.data) { cur_ptr.left = _delete(cur_ptr.left,val); }
        else if(val > cur_ptr.data) { cur_ptr.right = _delete(cur_ptr.right, val); }
        else {
            //case 1 : if node to be deleted has no children.
            if(cur_ptr.left == null && cur_ptr.right == null) {
                return null;
            }

            //case 2: if node to be deleted has 2 children.
            else if(cur_ptr.right != null && cur_ptr.left != null) {
                Node node = _minKeyInBST(cur_ptr.right);
                cur_ptr.data = node.data;
                cur_ptr.right = _delete(cur_ptr.right, node.data);
            }

            //case 3 : node to be deleted has only one child.
            else {
                Node node = (cur_ptr.left != null) ? cur_ptr.left : cur_ptr.right;
                cur_ptr = node;
            }
        }
        return cur_ptr;
    }
    private Node _minKeyInBST(Node cur_ptr) {
        while(cur_ptr.left != null) { cur_ptr = cur_ptr.left; }
        return cur_ptr;
    }
    private Node _maxKeyInBST(Node cur_ptr) {
        while(cur_ptr.right != null) { cur_ptr = cur_ptr.right; }
        return cur_ptr;
    }
    private void _preOrder(Node cur_ptr) {
        if(cur_ptr == null) { return; }
        System.out.print(cur_ptr.data + " - > ");
        _preOrder(cur_ptr.left);
        _preOrder(cur_ptr.right);
    }
    private void _postOrder(Node cur_ptr) {
        if(cur_ptr == null) { return; }
        _postOrder(cur_ptr.left);
        _postOrder(cur_ptr.right);
        System.out.print(cur_ptr.data + " -> ");
    }
    private void _inOrder(Node cur_ptr) {
        if(cur_ptr == null) { return; }
        _inOrder(cur_ptr.left);
        System.out.print(cur_ptr.data + " -> ");
        _inOrder(cur_ptr.right);
    }
    private void _levelOrderTraversal(Node cur_ptr) {
        if(cur_ptr == null) { return;}
        queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int nodeLevel = queue.size();
            while (nodeLevel > 0) {
                Node node = queue.poll();
                assert node != null;
                System.out.print(node.data + " ");
                if(node.left != null) { queue.add(node.left); }
                if(node.right != null) { queue.add(node.right); }
                nodeLevel -- ;
            }
            System.out.println();
        }
    }
    private void _reverseLevelOrderTraversal(Node cur_ptr) {
        if(cur_ptr == null) { return; }
        stack  = new Stack<Integer>();
        queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            stack.add(node.data);
            if(node.left != null) { queue.add(node.left); }
            if(node.right != null) { queue.add(node.right); }
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
    private void _verticalOrderTraversal(Node cur_ptr) {
        if(cur_ptr == null) { return; }
        int hd = 0;
        cur_ptr.horiz_dist = hd;
        List<Integer> l;
        SortedMap<Integer, List<Integer>> sortedMap = new TreeMap<>();
        queue = new LinkedList<>();
        queue.add(cur_ptr);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            hd = node.horiz_dist;
            if (!sortedMap.containsKey(hd)) {
                l = new ArrayList<Integer>();
                l.add(node.data);
                sortedMap.put(hd, l);
            } else {
                sortedMap.get(hd).add(node.data);
            }

            if (node.left != null) { node.left.horiz_dist = hd - 1; queue.add(node.left); }
            if (node.right != null) { node.right.horiz_dist = hd + 1; queue.add(node.right); }
        }
        for (Map.Entry<Integer, List<Integer>> integerListEntry : sortedMap.entrySet()) {
            System.out.println(integerListEntry.getKey() + " -> " + integerListEntry.getValue());
        }
    }
    private void _topView(Node cur_ptr) {
        queue = new LinkedList<>();
        SortedMap sortedMap = new TreeMap();
        queue.add(cur_ptr);
        int hd = 0;
        cur_ptr.horiz_dist = hd;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            hd = node.horiz_dist;
            if(!sortedMap.containsKey(hd)) { sortedMap.put(hd, node.data); }
            if(node.left != null) { node.left.horiz_dist = hd - 1; queue.add(node.left); }
            if(node.right != null) {node.right.horiz_dist = hd + 1; queue.add(node.right); }
        }
        System.out.println(sortedMap.values());
    }
    private int _heightOfTree(Node cur_ptr) {
        if(cur_ptr == null) { return 0; }
        int left_height = _heightOfTree(cur_ptr.left);
        int right_height = _heightOfTree(cur_ptr.right);
        return 1 + Math.max(left_height, right_height);
    }
    private void _diagonalElements(Node cur_ptr) {
//        queue = new LinkedList<>();
//        queue.add(cur_ptr);
//        queue.add(null);
//        while (!queue.isEmpty()) {
//            practice.BinarySearchTree.Node node = queue.poll();
//            if (node == null) {
//                queue.add(null);
//                node = queue.poll();
//                if (node == null) { break; }
//            }
//
//            while (node != null) {
//                System.out.print(node.data + " ");
//                if(node.left != null) { queue.add(node.left); }
//                node = node.right;
//            }
//        }
        List list;
        queue = new LinkedList<>();
        SortedMap<Integer, List<Integer>> sortedMap = new TreeMap<>();
        int hd = 0;
        queue.add(cur_ptr);
        cur_ptr.horiz_dist = hd;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            hd = node.horiz_dist;
            if(!sortedMap.containsKey(hd)) {
                list = new ArrayList();
                list.add(node.data);
                sortedMap.put(hd,list);
            } else {
                sortedMap.get(hd).add(node.data);
            }

            if(node.left != null) { node.left.horiz_dist = hd + 1; queue.add(node.left); }
            if(node.right != null) { node.right.horiz_dist = hd; queue.add(node.right); }
        }
        for(Map.Entry<Integer, List<Integer>> entry : sortedMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
    private int _diameter(Node cur_ptr) {
        if(cur_ptr == null) { return 0; }
        int left_height = _heightOfTree(cur_ptr.left);
        int right_height = _heightOfTree(cur_ptr.right);

        int left_dia = _diameter(cur_ptr.left);
        int right_dia = _diameter(cur_ptr.right);

        return Math.max(left_height + right_height + 1, Math.max(left_dia,right_dia));
    }
    private boolean _ancestorsOfNode(Node cur_ptr, Node ref) {
        if(cur_ptr != null) {
            if(cur_ptr.data == ref.data) { return true; }
            if(_ancestorsOfNode(cur_ptr.left, ref) || _ancestorsOfNode(cur_ptr.right, ref)) {
                System.out.print(cur_ptr.data + " -> ");
                return true;
            }
        }
        return false;
    }
    private Node _lowestCommonAncestor(Node cur_ptr, Node ref1, Node ref2) {
        if(cur_ptr == null) { return null; }
        if(cur_ptr == ref1 || cur_ptr == ref2) { return cur_ptr; }
        Node left_c = _lowestCommonAncestor(cur_ptr.left, ref1, ref2);
        Node right_c = _lowestCommonAncestor(cur_ptr.right, ref1, ref2);
        if(left_c == null && right_c == null) { return null; }
        else if(left_c != null && right_c != null) { return cur_ptr; }
        return left_c != null ? left_c : right_c;
    }
    private boolean _checkBST(Node cur_ptr, int min, int max) {
        if(cur_ptr == null) { return true; }
        if(cur_ptr.data > min && cur_ptr.data < max
                && _checkBST(cur_ptr.left, min, cur_ptr.data)
                && _checkBST(cur_ptr.right, cur_ptr.data, max)) {
            return true;
        } else { return false; }
    }

    public static void main(String[] args) {
        Main bst = new Main();
        bst.insert(100);
        bst.insert(50);
        bst.insert(120);
        bst.insert(40);
        bst.insert(70);
        bst.insert(110);
        bst.insert(140);
    }
}

