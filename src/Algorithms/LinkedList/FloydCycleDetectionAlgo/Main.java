package Algorithms.LinkedList.FloydCycleDetectionAlgo;

/*
Approach - 1:
Using Hash Tables we can solve this problem.
> Traverse the linked list nodes one by one.
> Check if the address of the node is available in the hash table or not.
> If it is already available in the hash table, that indicates that we are visiting the node
    that was already visited. This is possible only if the given linked list has a loop in it.
> If the address of the node is not available in the hash table, insert that node’s address into the hash table.
> Continue this process until we reach the end of the linked list or we find the loop.

Approach - 2:
This problem was solved by Floyd. The solution is named the Floyd cycle finding algorithm.
It uses two pointers moving at different speeds to walk the linked list.
Once they enter the loop they are expected to meet, which denotes that there is a loop.
*/

//Floyd cycle detection algorithm in LL
//Detect the loop. If loop exists than find the start node of loop and remove the loop.
//we take 1 and 2 steps while detecting loop. Can we take 2 and 3 steps ?
//Yes, we can but the complexity will be high.

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
        System.out.println();
    }

    static void detectCycle() {
        Node slow_ptr = head, fast_ptr = head;
        boolean loopExists = false;
        while (slow_ptr != null && fast_ptr != null && fast_ptr.next != null) {
            slow_ptr = slow_ptr.next;
            fast_ptr = fast_ptr.next.next;
            if(slow_ptr == fast_ptr) {
                System.out.println("eureka eureka loop found !");
                System.out.println("Meeting node is " + slow_ptr.data);
                loopExists = true;
                break;
            }
        }

        //identifying the start node of the loop.
        if(loopExists) {
            slow_ptr = head;
            while (slow_ptr != fast_ptr) {
                fast_ptr = fast_ptr.next;
                slow_ptr = slow_ptr.next;
            }
            System.out.println("loop starts at : " + fast_ptr.data);
        }

        //removing the loop.
        fast_ptr = fast_ptr.next;
        while (fast_ptr.next != slow_ptr) {
            fast_ptr = fast_ptr.next;
        }
        fast_ptr.next = null;
        System.out.println("The loop is removed!");
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

        display();
        //make circle
        head.next.next.next.next.next.next.next.next.next.next = head.next.next.next.next;
        detectCycle();
        display();
    }
}
