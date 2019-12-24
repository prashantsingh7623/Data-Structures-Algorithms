package Algorithms.LinkedList.Josephus_circle;

/*
Josephus Circle: N people have decided to elect a leader by arranging
themselves in a circle and eliminating every Mth person around the circle,
closing ranks as each person drops out. Find which person will be the last one remaining (with rank 1).
*/

//solution can be implemented using circular LL.

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
            while (ptr.next != head && ptr.next != null) {
                ptr = ptr.next;
            }
            ptr.next = new Node(data);
            ptr.next.next = head;
        }
    }

    static void findWinner(int m) {
        Node ptr = head, prev = head;
        while (ptr.next != ptr) {
            for(int i=0; i<m-1; i++) { prev = ptr; ptr = ptr.next; }
            prev.next = ptr.next;
        }
        System.out.println("winner : " + ptr.data);
    }

    static void display() {
        Node ptr = head;
        while (ptr.next != head) {
            System.out.print(ptr.data + " -> ");
            ptr = ptr.next;
        }
        System.out.println(ptr.data);
        System.out.println();
    }

    public static void main(String[] args) {
        insert(10);insert(20);insert(30);insert(40);insert(50);
        insert(60);insert(70);
        display();
        findWinner(2);
    }
}
