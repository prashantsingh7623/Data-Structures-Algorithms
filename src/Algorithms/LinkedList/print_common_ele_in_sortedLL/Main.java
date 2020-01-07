package Algorithms.LinkedList.print_common_ele_in_sortedLL;

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
    static Node findCommon(Node head_1, Node head_2) {
        Node ptr = new Node(-1);
        Node ptr_head = ptr;
        while (head_1 != null && head_2 != null) {
            if(head_1.data == head_2.data) {
                ptr_head.next = new Node(head_1.data);
                head_1 = head_1.next;
                head_2 = head_2.next;
                ptr_head = ptr_head.next;
            } else if(head_1.data < head_2.data) {
                head_1 = head_1.next;
            } else {
                head_2 = head_2.next;
            }
        }
        return ptr.next;
    }
    void display(Node cur_head) {
        Node ptr = cur_head;
        while (ptr != null) {
            System.out.print(ptr.data + " -> ");
            ptr = ptr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Main l1 = new Main();
        l1.insert(10);l1.insert(20);l1.insert(30);l1.insert(40);l1.insert(50);
        l1.display(l1.head);

        Main l2 = new Main();
        l2.insert(1);l2.insert(20);l2.insert(25);l2.insert(50);
        l2.display(l2.head);

        Node l3_head = findCommon(l1.head, l2.head);
        Main l3 = new Main();
        l3.display(l3_head);
    }
}
