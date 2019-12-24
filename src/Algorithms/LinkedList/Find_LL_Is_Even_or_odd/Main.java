package Algorithms.LinkedList.Find_LL_Is_Even_or_odd;

//find whether the LL has even length or ODD length.
/* best approach is doing it with fast pointer.
* Use a 2x pointer. Take a pointer that moves at 2x [two nodes at a time].
* At the end, if the length is even, then the pointer will be NULL;
* otherwise it will point to the last node.
* complexity : O(n/2) == O(n), space = O(1)
* */

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

    static boolean llIsEvenOrOdd() {
        Node fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if(fast == null) { return true; }
        else { return false; }
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
        insert(50);
        display();
        System.out.println(llIsEvenOrOdd());
    }
}
