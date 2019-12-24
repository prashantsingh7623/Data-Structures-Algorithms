package Algorithms.LinkedList.Merge_2_Sorted_LL.Recursive_approach;

/*
Time complexity O(m + n), space complexity O(m+n)
*/

class Node {
    int data;
    Node next;
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class Main {
    Node head = null;
    void insert(int data) {
        Node ptr = head;
        if(ptr == null) { head = new Node(data); }
        else {
            while (ptr.next != null) { ptr = ptr.next; }
            ptr.next = new Node(data);
        }
    }
    static Node mergeLL(Node head_1, Node head_2) {
        Node head_ptr = null;
        if(head_1 == null) { return head_2; }
        if(head_2 == null) { return head_1; }
        if(head_1.data <= head_2.data) {
            head_ptr = head_1;
            head_ptr.next = mergeLL(head_1.next, head_2);
        } else {
            head_ptr = head_2;
            head_ptr.next = mergeLL(head_1, head_2.next);
        }
        return head_ptr;
    }

    static void display(Node ptr) {
        while (ptr != null) {
            System.out.print(ptr.data + " -> ");
            ptr = ptr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        //creating 1st sorted LL
        Main l1 = new Main();
        l1.insert(10);l1.insert(20);l1.insert(30);l1.insert(40);
        display(l1.head);

        //creating another LL
        Main l2 = new Main();
        l2.insert(5);l2.insert(10);l2.insert(19);l2.insert(35);l2.insert(45);
        l2.insert(55);
        display(l2.head);

        Node l3 = mergeLL(l1.head, l2.head);
        display(l3);
    }
}
