package Algorithms.LinkedList.DoublyLL;

class Node {
    int data;
    Node l_child, r_child;
    Node(int data) {
        this.data = data;
        l_child = null;
        r_child = null;
    }
}

public class Main {

    //making head pointer to point to head node.
    static Node head = null;

    //insertion at End
    static void insertEnd(int data) {
        Node ptr = head;
        if(ptr == null) {
            head = new Node(data);
        } else {
            while (ptr.r_child != null) {
                ptr = ptr.r_child;
            }
            ptr.r_child = new Node(data);
        }
    }

    //insertion at begin
    static void insertBeg(int data) {
        Node ptr = head;
        ptr = new Node(data);
        ptr.r_child = head;
        head.l_child = ptr;
        head = ptr;
    }

    //insertion in middle
    static void insertionMid(int data, int pos) {
        Node ptr = head;
        if(pos < 2) {
            insertBeg(data);
        } else {
            Node prev = null, cur = null;
            while (pos > 1) {
                prev = ptr;
                ptr = ptr.r_child;
                pos --;
            }
            cur = ptr;
            ptr = new Node(data);
            prev.r_child = ptr;
            ptr.l_child = prev;
            ptr.r_child = cur;
            cur.l_child = ptr;
        }
    }

    //deletion at end
    static void deleteEnd() {
        Node ptr = head;
        if(ptr == null) {
            System.out.println("LL is empty!");
        } else {
            Node prev = null;
            while (ptr.r_child != null) {
                prev = ptr;
                ptr = ptr.r_child;
            }
            prev.r_child = null;
            ptr = null;
        }
    }

    //delete at beg
    static void deleteBeg() {
        if(head == null) {
            System.out.println("LL is empty!");
        } else {
            Node ptr = head;
            head = head.r_child;
            ptr = null;
        }
    }

    //delete at middle
    static void deleteMid(int pos) {
        Node ptr = head;
        if(pos < 2) { deleteBeg(); }
        else if(ptr == null) { System.out.println("LL is empty!"); }
        else {
            Node prev = null;
            while (pos > 1) {
                prev = ptr;
                ptr = ptr.r_child;
                pos --;
            }
            prev.r_child = ptr.r_child;
            ptr.r_child = prev;
        }
    }

    //traversing the LL
    static void display() {
        Node ptr = head;
        if(ptr == null) {
            System.out.println("LL is empty!");
        } else {
            while (ptr != null) {
                System.out.print(ptr.data + " -> ");
                ptr = ptr.r_child;
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        insertEnd(10);
        insertEnd(20);
        insertEnd(30);
        insertEnd(40);
        insertEnd(50);
        insertBeg(60);
        insertionMid(25,3);
        display();
        deleteEnd();
        display();
        deleteBeg();
        display();
        deleteMid(3);
        display();
    }
}
