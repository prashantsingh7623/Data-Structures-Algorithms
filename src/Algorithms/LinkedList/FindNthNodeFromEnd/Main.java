package Algorithms.LinkedList.FindNthNodeFromEnd;

//find nth from end.

/*
Approach : 1 - Brute force
Start with the first node and count the number of nodes present after that node.
If the number of nodes is < n – 1 then return saying “fewer number of nodes in the list”.
If the number of nodes is > n – 1 then go to next node.
Continue this until the numbers of nodes after current node are n – 1.
Time Complexity: O(n2), for scanning the remaining list (from current node) for each node.
Space Complexity: O(1).

Approach : 2 - Improvement over brute force
First we find the size of the LL(say M). This can be done using hash tables or direct traversing.
Then we find M + n - 1 and with one more scan we can get the M – n+ 1th node from the beginning.
This solution needs two scans: one for finding the length of the list and
the other for finding M – n+ 1th node from the beginning.
Time Complexity: Time for finding the length + Time for finding the M – n + 1th node from the beginning.
Therefore, T(n) = O(n) + O(n) ≈ O(n). Space Complexity: O(1). Hence, no need to create the hash table.

Approach : 3 - Efficient Approach (we can solve this problem in 1 scan)
Use two pointers pNthNode and pTemp. Initially, both point
to head node of the list. pNthNode starts moving only after pTemp has made n moves.
From there both move forward until pTemp reaches the end of the list. As a result pNthNode
points to nth node from the end of the linked list.
Time Complexity: O(n). Space Complexity: O(1).

Here we will apply Efficient approach
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

    static void findNode(int n) {
        Node ptrNth = head, ptrTemp = head;
        for(int i = 0; i<n; i++) { ptrTemp = ptrTemp.next; }
        while (ptrTemp != null) {
            ptrNth = ptrNth.next;
            ptrTemp = ptrTemp.next;
        }
        System.out.println(n + "rd node from last is " + ptrNth.data);
    }

    public static void main(String[] args) {
        insert(10);
        insert(20);
        insert(30);
        insert(40);
        insert(50);
        insert(60);
        insert(70);
        display();

        //find the 3rd node from last
        findNode(3);
    }
}
