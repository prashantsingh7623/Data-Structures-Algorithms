package Algorithms.LinkedList.reverse_k_nodes;

/*
*
Problem-38  For a given K value (K > 0) reverse blocks of K nodes in a list.
Example: Input: 1 2 3 4 5 6 7 8 9 10. Output for different K values:
For K = 2: 2 1 4 3 6 5 8 7 10 9
For K = 3: 3 2 1 6 5 4 9 8 7 10
For K = 4: 4 3 2 1 8 7 6 5 9 10

Solution:
Algorithm: This is an extension of swapping nodes in a linked list.
1) Check if remaining list has K nodes.
    a. If yes get the pointer of K + 1th node.
    b. Else return.
2) Reverse first K nodes.
3) Set next of last node (after reversal) to K + 1th node.
4) Move to K + 1th node.
5) Go to step 1.
6) K – 1th node of first K nodes becomes the new head if available. Otherwise, we can return the head.

* */

class Node {
    int data;
    Node next;
    Node(int data) {
        this.data = data;
        next = null;
    }
}

public class Main {
    static Node head = null;
    static void insert(int data) {
        Node ptr = head;
        if (ptr == null) { head = new Node(data);  return; }
        while (ptr.next != null) { ptr = ptr.next; }
        ptr.next = new Node(data);
    }
    static void reverseKNodes(int k) {
        Node ptr = head, cur_ptr = head;
        if(k == 0 || k == 1) { return; }
        while (ptr != null && _hasKNodes(ptr, k)) {
            Node temp = _getKPlusOneNodes(ptr, k);
            Node nextNode, newHead = null;
            int i = 0;
            while(i < k) {
                nextNode = cur_ptr.next;
                cur_ptr.next = newHead;
                newHead = cur_ptr;
                cur_ptr = nextNode;
                i++;
            }
            i = 0;
            while (i < k-1) { newHead = newHead.next; }
        }
    }
    static boolean _hasKNodes(Node ptr, int k) {
        if(k == 0 || k == 1) { return false;}
        int i = 0;
        for(i = 0; (ptr != null && (i < k)); i++, ptr = ptr.next);
        if(i == k)
            return true;
        return false;
    }
    static Node _getKPlusOneNodes(Node ptr, int k) {
        Node Kth;
        int i = 0;
        for (i = 0, Kth = ptr; (Kth != null && (i < k)); i++, Kth = Kth.next) ;
        if (i == k && Kth != null) {
            return Kth;
        }
        return ptr.next;
    }
    static void display() {
        Node ptr = head;
        if (ptr == null) { return; }
        while (ptr != null) {
            System.out.print(ptr.data + " -> ");
            ptr = ptr.next;
        }
    }

    public static void main(String[] args) {
        insert(1);insert(2);insert(3);insert(4);insert(5); insert(6);
        display();
        //Node temp = _getKPlusOneNodes(head.next.next.next,3);
        //System.out.println("temp : " + temp.data);
    }
}
