package Algorithms.LinkedList.CircularLL;

//Node class definition
class Node {
    int data;
    Node next;
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class CircularLL {

    //head pointer
    static Node head = null;

    //counting nodes in LL
    static int countNodes(Node ptr) {
        if(ptr.next == head) {
            return 1;
        } else {
            return 1 + countNodes(ptr.next);
        }
    }

    //insertion at end
    static void insertEnd(int data) {
        Node ptr = head;
        if (ptr == null) {
            head = new Node(data);
        } else {
            while (ptr.next != head && ptr.next != null) {
                ptr = ptr.next;
            }
            ptr.next = new Node(data); //at this stage ptr is pointing to current node only.
            ptr = ptr.next;
            ptr.next = head;
        }
    }

    //inserting at front
    static void insertBeg(int data) {
        Node ptr = head;
        while (ptr.next != head) {
            ptr = ptr.next;
        }
        Node prev = ptr;
        ptr = new Node(data);
        prev.next = ptr;
        ptr.next = head;
        head = ptr;
    }

    //insert at middle
    static void insertMid(int data, int pos) {
        Node ptr = head;
        if(pos < 2) {
            insertBeg(data);
        } else {
            Node prev = null, after = null;
            while (pos > 1) {
                prev = ptr;
                ptr = ptr.next;
                pos --;
            }
            after = ptr;
            ptr = new Node(data);
            ptr.next = after;
            prev.next = ptr;
        }
    }

    //delete at end
    static void deleteEnd() {
        Node ptr = head;
        if(ptr == null) {
            System.out.println("LL is empty!");
        } else {
            Node prev = null;
            while (ptr.next != head) {
                prev = ptr;
                ptr = ptr.next;
            }
            prev.next = head;
            ptr = null;
        }
    }

    //delete at start
    static void deleteBeg() {
        Node ptr = head;
        if(ptr == null) {
            System.out.println("LL is empty!");
        } else {
            while (ptr.next != head) {
                ptr = ptr.next;
            }
            head = head.next;
            Node after = ptr.next;
            ptr.next = after.next;
        }
    }

    //display
    static void display() {
        Node ptr = head;
        if(ptr == null) {
            System.out.println("LL is empty!");
        } else {
            while (ptr.next != head) {
                System.out.print(ptr.data + " -> ");
                ptr = ptr.next;
            }
            System.out.print(ptr.data);
        }
        System.out.println();
    }

    public static void main(String[] args) {

        insertEnd(10);
        insertEnd(20);
        insertEnd(30);
        insertEnd(40);
        insertEnd(50);
        display();
//        insertBeg(60);
//        display();
//        insertMid(70,3);
//        display();
//        System.out.println(countNodes(head));
//        deleteEnd();
//        display();
//        deleteBeg();
//        display();

    }
}
