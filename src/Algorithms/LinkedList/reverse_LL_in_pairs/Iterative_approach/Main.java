package Algorithms.LinkedList.reverse_LL_in_pairs.Iterative_approach;

/*
Reverse the linked list in pairs. If you have a linked list that holds 1 → 2 → 3 → 4 → X,
then after the function has been called the linked list would hold 2 → 1 → 4 → 3 → X.
*/

import jdk.dynalink.linker.LinkerServices;

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
        if(ptr == null) { head = new Node(data); }
        else {
            while (ptr.next != null) { ptr = ptr.next; }
            ptr.next = new Node(data);
        }
    }

    static void reverseLL () {
        Node first = head, second = head.next;
        while (first != null && second != null) {
            first.data = first.data + second.data;
            second.data = first.data - second.data;
            first.data = first.data - second.data;
            first = first.next;
            if(first != null) { first = first.next; }
            second = second.next;
            if(second != null) { second = second.next; }
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
        insert(10);insert(20);insert(30);insert(40);insert(50);insert(60);
        display();
        reverseLL();
        display();
    }
}
