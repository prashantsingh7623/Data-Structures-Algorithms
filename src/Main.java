class Node {
    int data;
    Node next;
    Node(int data) {
        this.data = data;
        next = null;
    }
}

public class Main {
    static Node head = null;
    static void insert(int data) {
        Node ptr = head;
        if (ptr == null) { head = new Node(data);  return; }
        while (ptr.next != null) { ptr = ptr.next; }
        ptr.next = new Node(data);
    }

    static void display() {
        Node ptr = head;
        if(ptr == null) {
            System.out.println("LL is empty...!");
            return;
        }
        while (ptr != null) {
            System.out.print(ptr.data + " -> ");
            ptr = ptr.next;
        }
    }

    static Node reverseLL() {
        Node new_head = null;
        Node nextNode;
        Node ptr = head;
        int count = 1;
        while (count != 4) {
            nextNode = head.next;
            head.next = new_head;
            new_head = head;
            head = nextNode;
            count += 1;
        }
        return new_head;
    }

    public static void main(String[] args) {
        insert(1); insert(2); insert(3); insert(4); insert(5);
        display();
        head = reverseLL();
        System.out.println();
        display();

    }
}