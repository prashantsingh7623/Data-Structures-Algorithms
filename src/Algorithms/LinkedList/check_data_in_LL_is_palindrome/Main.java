package Algorithms.LinkedList.check_data_in_LL_is_palindrome;

/*To check whether the data in LL is Palindrome or not.
Traverse the LL and store all the data in empty String and than
Simply check whether the String is palindrome or not.*/

import java.util.Stack;

class Node {
    char data;
    Node next;
    Node(char data) {
        this.data = data;
        next = null;
    }
}

public class Main {
    static Node head = null;
    static void insert(char[] arr) {
        if (head == null) { head = new Node(arr[0]);}
        for (int j = 1; j < arr.length; j++) {
            Node ptr = head;
            while (ptr.next != null) {
                ptr = ptr.next;
            }
            ptr.next = new Node(arr[j]);
        }
    }
    static void display() {
        if (head == null) {
            System.out.println("LL is empty..!");
            return;
        }
        Node ptr = head;
        while (ptr != null) {
            System.out.print(ptr.data + " -> ");
            ptr = ptr.next;
        }
        System.out.println();
    }

    static boolean isPalindrome() {
        int len = findLength(head);
        Node prev = null, new_head = head;
        for (int i=0; i<len / 2; i++) {
            prev = new_head;
            new_head = new_head.next;
        }
        if (len % 2 == 0) {
            prev.next = null;
        } else if (len % 2 == 1) {
            new_head = new_head.next;
            prev.next = null;
        }

        Stack<Character> stack1 = new Stack<>(), stack2 = new Stack<>();
        prev = head;
        while (prev != null) { stack1.push(prev.data); prev = prev.next; }
        while (new_head != null) { stack2.add(0, new_head.data); new_head = new_head.next; }
        return stack1.equals(stack2);
    }

    static int findLength(Node ptr) {
        if (ptr == null) { return 0; }
        else { return 1 + findLength(ptr.next); }
    }

    public static void main(String[] args) {
        char[] arr = {'a','b','b','a'};
        insert(arr);
        display();
        System.out.println(isPalindrome());
    }
}
