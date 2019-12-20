package Algorithms.LinkedList.SinglyLL;

import javax.xml.stream.events.NotationDeclaration;

//creating the definition of Node class
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

    //insertion at end
    static void insertEnd(int data) {
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

    //insertion at beginning
    static void insertBeg(int data) {
        Node ptr = head;
        if(ptr == null) { head = new Node(data); }
        else {
            ptr = new Node(data);
            ptr.next = head;
            head = ptr;
        }
    }

    //insertion at middle
    static void insertMid(int data, int pos) {
        if(pos < 2) {
            insertBeg(data);
        } else {
            Node ptr = head;
            if(ptr == null) {
                System.out.println("LL is empty! inserting the node at 1 position.");
                head = new Node(data);
            } else {
                Node f = null, l = null;
                while (pos > 1) {
                    f = ptr;
                    ptr = ptr.next;
                    pos -- ;
                }
                l = ptr;
                ptr = new Node(data);
                ptr.next = l;
                f.next = ptr;
            }
        }
    }

    //deletion from end
    static void deleteEnd() {
        Node ptr = head;
        if(ptr == null) {
            System.out.println("LL is empty!");
        } else {
            Node prev = null;
            while (ptr.next != null) {
                prev = ptr;
                ptr = ptr.next;
            }
            prev.next = null;
        }
    }

    //delete from beginning
    static void deleteBeg() {
        Node ptr = head;
        if(ptr == null) {
            System.out.println("LL is empty!");
        } else {
            head = head.next;
            ptr.next = null;
        }
    }

    //delete at middle
    static void deleteMid(int pos) {
        Node ptr = head;
        if(pos < 2) {
            deleteBeg();
        }
        else if(ptr == null) {
            System.out.println("LL is empty!");
        }
        else {
            Node prev = null, forw;
            while (pos > 1) {
                prev = ptr;
                ptr = ptr.next;
                pos--;
            }
            forw = ptr.next;
            prev.next = forw;
            ptr = null;
        }
    }

    //traversing
    static void display() {
        Node ptr = head;
        if(ptr == null) {
            System.out.println("LL is empty!");
        } else {
            while (ptr != null) {
                System.out.print(ptr.data + " -> ");
                ptr = ptr.next;
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Main.insertEnd(10);
        Main.insertEnd(20);
        Main.insertEnd(30);
        Main.insertEnd(40);
        Main.display();
        Main.deleteMid(1);
        Main.display();
    }
}