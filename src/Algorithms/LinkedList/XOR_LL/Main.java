package Algorithms.LinkedList.XOR_LL;

/*
An ordinary Doubly Linked List requires space for two address fields to store the addresses of
previous and next nodes. A memory efficient version of Doubly Linked List can be created
using only one space for address field with every node.
This memory efficient Doubly Linked List is called XOR Linked List or Memory Efficient
as the list uses bitwise XOR operation to save space for one address.
In the XOR linked list, instead of storing actual memory addresses,
every node stores the XOR of addresses of previous and next nodes.
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
    static Node XOR(Node a, Node b) {
       // return (Node)(a.hashCode() ^ b.hashCode());
        /* cannot be implemented in java. JAVA don't support REFERENCE ARITHMETIC.
        you cannot get the address of an object
        */
        return null;
    }

    static void insert(int data) {
        Node ptr = head;
        if(ptr == null) { head = new Node(data); }
        else {
            while (ptr.next != null) { ptr = ptr.next; }
            ptr.next = new Node(data);
        }
    }

    static void display() {
        Node ptr = head;
        while (ptr != null) {
            System.out.print(ptr.data + " -> ");
            ptr = ptr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        insert(10);
        insert(20);
        insert(30);
        insert(40);
        display();
    }
}
