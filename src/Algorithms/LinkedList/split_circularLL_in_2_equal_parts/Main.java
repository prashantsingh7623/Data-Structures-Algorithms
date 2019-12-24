package Algorithms.LinkedList.split_circularLL_in_2_equal_parts;

/*Split a Circular Linked List into two equal parts.
If the number of nodes in the list are odd then make first list one node extra than second list.*/

/*Algorithm:
• Store the mid and last pointers of the circular linked list using Floyd cycle finding algorithm.
• Make the second half circular.
• Make the first half circular.
• Set head pointers of the two linked lists.

Time Complexity: O(n). Space Complexity: O(1).
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
    static Node head = null;

    static void insert(int data) {
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

    static Node splitLL() {
        Node slow = head, fast = head.next;
        while (slow != null && fast != null && fast.next != head) {
            slow = slow.next;
            fast = fast.next;
            if(fast.next != head) { fast = fast.next; }
            else { break; }
        }
        Node ptr  = slow.next;
        slow.next = head;
        fast.next = ptr;
        return ptr;
    }

    static void display(Node cur_ptr) {
        Node ptr = cur_ptr;
        while (ptr.next != cur_ptr) {
            System.out.print(ptr.data + " -> ");
            ptr = ptr.next;
        }
        System.out.println(ptr.data);
        System.out.println();
    }

    public static void main(String[] args) {
        insert(10);insert(20);insert(30);insert(40);insert(50);
        display(head);
        Node head_2 = splitLL();
        display(head);
        display(head_2);
    }
}
