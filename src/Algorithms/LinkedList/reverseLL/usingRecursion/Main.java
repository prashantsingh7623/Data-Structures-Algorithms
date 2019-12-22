package Algorithms.LinkedList.reverseLL.usingRecursion;

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

    static Node reverseUsingRecursion_1(Node head) {
        if(head == null) { return null;}
        if(head.next == null) { return head; }
        Node nextNode = head.next;
        head.next = null;
        Node reversePtr =  reverseUsingRecursion_1(nextNode);
        nextNode.next = head;
        return reversePtr;
    }

    static void reverseUsingRecursion_2(Node ptr) {
        if(ptr.next == null) {
            head = ptr;
            return;
        }
        reverseUsingRecursion_2(ptr.next);
        Node nextNode = ptr.next;
        nextNode.next = ptr;
        ptr.next = null;
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
        Node ptr = reverseUsingRecursion_1(head);
        head = ptr;
        display();
        reverseUsingRecursion_2(head);
        display();
    }
}
