package Algorithms.LinkedList.reverseLL.printUsingRecursion;

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
        Node ptr  = head;
        if(ptr == null) { head = new Node(data); }
        else {
            while(ptr.next != null) {
                ptr = ptr.next;
            }
            ptr.next = new Node(data);
        }
    }

    static void printUsingRecursion(Node ptr) {
        if(ptr == null) {return;}
        printUsingRecursion(ptr.next);
        System.out.print(ptr.data + " -> ");
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
        printUsingRecursion(head);
    }
}
