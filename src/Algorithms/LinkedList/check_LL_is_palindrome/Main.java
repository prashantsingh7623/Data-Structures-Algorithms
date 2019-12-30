package Algorithms.LinkedList.check_LL_is_palindrome;

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
    static boolean isPalindrome() {
        Node ptr = head, slow = head, fast = head, prev = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        int count = countLL(ptr);
        Node midlle = null;
        if(count % 2 == 0) { midlle = slow; prev.next = null;}
        else { midlle = slow.next; prev.next = null;}
        Node mid = reverseLL(midlle);
        while (ptr != null && mid != null) {
            if(ptr.data != mid.data) { return false; }
            ptr = ptr.next; mid = mid.next;
        }
        return true;
    }
    private static int countLL(Node ptr) {
        if(ptr == null) { return 0; }
        else { return 1 + countLL(ptr.next); }
    }
    static Node reverseLL(Node head) {
        Node ptr = head;
        Node temp = null, nextNode = null;
        while (head != null) {
            nextNode = head.next;
            head.next = temp;
            temp = head;
            head = nextNode;
        }
        return temp;
    }
    static void display(Node ptr) {
        while(ptr != null) {
            System.out.print(ptr.data + " -> ");
            ptr = ptr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        insert(10);insert(20);insert(20);insert(10);
        display(head);
        System.out.println(isPalindrome());
    }
}
