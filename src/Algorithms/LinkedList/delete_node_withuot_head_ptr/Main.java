package Algorithms.LinkedList.delete_node_withuot_head_ptr;

/*
* You are given a singly linked list and pointer which is pointing to the node which is
* required to be deleted. Any information about head pointer or any other node is not given.
* You need to write a function to delete that node from linked list.
* */

class Node {
    int data;
    Node next;
    Node(int data) {
        this.data =data;
        this.next = null;
    }
}

public class Main {
    static Node head = null;
    static void insertNode(int data) {
        Node ptr = head;
        if (ptr == null) { head = new Node(data); }
        else {
            while (ptr.next != null) { ptr = ptr.next; }
            ptr.next = new Node(data);
        }
    }
    static void deleteNode(Node node) {
        if(node == null) {
            System.out.println("corresponding node does't exist...!");
            return;
        }
        Node temp = node.next;
        node.data = temp.data;
        node.next = temp.next;
    }
    static void display() {
        Node ptr = head;
        if(ptr == null) {
            System.out.println("LL is empty...!");
        }
        while (ptr != null) {
            System.out.print(ptr.data + " -> ");
            ptr = ptr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        insertNode(10); insertNode(20); insertNode(30); insertNode(40);
        display();
        deleteNode(head.next);
        display();
    }
}
