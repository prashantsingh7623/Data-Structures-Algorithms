package Algorithms.LinkedList.FloydCycleDetectionAlgo;

//Floyd cycle detection algorithm in LL

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
    static void insertEnd(int data) {
        Node ptr = head;
        if(ptr == null) { head = new Node(data); }
        else {
            while (ptr.next != null) {
                ptr = ptr.next;
            }
            ptr.next = new Node(data);
        }
    }

    static void display() {
        Node ptr = head;
        while (ptr != null) {
            System.out.print(ptr.data + " -> ");
            ptr = ptr.next;
        }
    }

    static void detectCycle() {
        Node slow_ptr = head, fast_ptr = head;
        boolean loopExists = false;
        while (slow_ptr != null && fast_ptr != null && fast_ptr.next != null) {
            slow_ptr = slow_ptr.next;
            fast_ptr = fast_ptr.next.next;
            if(slow_ptr == fast_ptr) {
                System.out.println("eureka eureka loop found !");
                loopExists = true;
                break;
            }
        }
        if(loopExists) {
            slow_ptr = head;
            while (slow_ptr != fast_ptr) {
                slow_ptr = slow_ptr.next;
                fast_ptr = fast_ptr.next;
            }
            System.out.println("loop starts : " + slow_ptr.data);
        }
    }

    public static void main(String[] args) {
        insertEnd(10);
        insertEnd(20);
        insertEnd(30);
        insertEnd(40);
        insertEnd(50);
        insertEnd(60);
        insertEnd(70);
        insertEnd(80);
        insertEnd(90);
        insertEnd(100);

        //make circle
        head.next.next.next.next.next.next.next.next.next = head.next.next.next;
        detectCycle();
    }
}
