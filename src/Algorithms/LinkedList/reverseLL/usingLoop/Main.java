package Algorithms.LinkedList.reverseLL.usingLoop;

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
        if (ptr == null) {
            head = new Node(data);
        } else {
            while (ptr.next != null) {
                ptr = ptr.next;
            }
            ptr.next = new Node(data);
        }
    }

    static Node reverseLL() {
        Node nextNode = null, temp = null;
        while (head != null) {
            nextNode = head.next;
            head.next = temp;
            temp = head;
            head = nextNode;
        }
        return temp;
    }

    static void display() {
        Node ptr = head;
        while (ptr != null) {
            System.out.print(ptr.data + " -> ");
            ptr = ptr.next;
        }
        System.out.println();
    }

    static void displayUsingRecursion(Node head) {
        if(head == null) { return; }
        System.out.print(head.data + " -> ");
        displayUsingRecursion(head.next);
        System.out.println();
    }

    public static void main(String[] args) {
        insert(10);
        insert(20);
        insert(30);
        insert(40);
        Node temp = reverseLL();
        head = temp;
        display();
    }
}
