package Algorithms.LinkedList.reverse_LL_in_pairs.Recursive_approach;

/*
Reverse the linked list in pairs. If you have a linked list that holds 1 → 2 → 3 → 4 → X,
then after the function has been called the linked list would hold 2 → 1 → 4 → 3 → X.
*/

class Node {
    int data;
    Node next;
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class Main {
    static Node head = null;
    static void insert(int data) {
        Node ptr = head;
        if (ptr == null) { head = new Node(data); return; }
        while (ptr.next != null) { ptr = ptr.next; }
        ptr.next = new Node(data);
    }

    static void display() {
        Node ptr = head;
        if (ptr == null) { return; }
        while (ptr != null) {
            System.out.print(ptr.data + " -> ");
            ptr = ptr.next;
        }
    }

    static Node reverseLLPairWise(Node ptr) {
        Node temp;
        if(ptr == null || ptr.next == null) { return null; }
        else {
            temp = ptr.next;
            ptr.next = temp.next;
            temp.next = ptr;
            ptr = temp;
            ptr.next.next = reverseLLPairWise(ptr.next.next);
            return ptr;
        }
    }

    public static void main(String[] args) {
        insert(1);insert(3);insert(3);insert(4);insert(5);
        display();
        head = reverseLLPairWise(head);
        System.out.println();
        display();
    }
}
