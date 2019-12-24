package Algorithms.LinkedList.intersection_Of_2_LL;

/*
when 2 LL has same data nodes, than instead of keeping the duplicate data in both the LL, we merge them.
LL_1 : 10->20->30->40>50
LL_2 : 100->200->40->50
we merge the above LL to remove duplication of data.
*/

import java.util.HashSet;
import java.util.Set;

class Node {
    int data;
    Node next;
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class Main {

    /*
    * if i make the below statement as static than only one head will be created for both the LL.
    */

    Node head = null;

    void insert(int data) {
        Node ptr = head;
        if(ptr == null) { head = new Node(data); }
        else {
            while (ptr.next != null) { ptr = ptr.next; }
            ptr.next = new Node(data);
        }
    }

    static void mergeLL(Node l1, Node l2) {
        l1 = l1.next.next;
        l2 = l2.next.next.next.next;
        l2.next = l1;
    }

    //methdo to find the length of LL
    static int lengthLL(Node ptr) {
        if(ptr.next == null) { return 1; }
        return 1 + lengthLL(ptr.next);
    }

    /*finding the intersection LL using Brute force method.
    * since there are two while loops , this method will have O(m.n) time complexityt*/
    static void findIntersectionPoint_BruteForce(Node l1, Node l2) {
        Node ptr_1 = l1, ptr_2 = l2;
        while (ptr_1.next != null) {
            ptr_1 = ptr_1.next;
            ptr_2 = l2;
            while (ptr_2.next != null) {
                ptr_2 = ptr_2.next;
                if(ptr_1 == ptr_2) {
                    System.out.println("merge found at : " + ptr_1.data);
                    return;
                }
            }
        }
    }

    /*finding the intersection LL by improvement over brute force.
    * since there are two while loops and insert, contains operation takes log(n) time.
    * so total time complexity is O(mlog(n) + nlog(n))
    * */
    static void finIntersectionPoint_ImpBruteForce(Node l1, Node l2) {
        Set<Node> set = new HashSet<Node>();
        while (l1 != null) {
            set.add(l1);
            l1 = l1.next;
        }
        while (l2 != null) {
            if(set.contains(l2)) { System.out.println("merge found at : " + l2.data); return;}
            l2 = l2.next;
        }
    }

    /*finding the intersection of LL using Best Solution.
    overall complexity : O(max(m,n)) , space : O(1).
    */
    static void findIntersection_BestSolution(Node head1, Node head2) {
        //find the length of LL.
        int len_1 = lengthLL(head1); //O(m)
        int len_2 = lengthLL(head2); //O(n)

        //applying algo
        // O(m + n)
        if(len_1 == len_2) {
            while (head1 != null && head2 != null) {
                if(head1 == head2) { System.out.println("merge found at : " + head1.data); return; }
                head1 = head1.next;
                head2 = head2.next;
            }
        }
        else if(len_1 > len_2) {
            int len_diff = len_1 - len_2;
            for(int i=0; i<len_diff; i++) { head1 = head1.next; }
            while (head1 != null && head2 != null) {
                if (head1 == head2) { System.out.println("merge found at : " + head1.data); return; }
                head1 = head1.next;
                head2 = head2.next;
            }
        }
        else {
            int len_diff = len_2 - len_1;
            for(int i=0; i<len_diff; i++) { head2 = head2.next; }
            while (head1 != null && head2 != null) {
                if (head1 == head2) { System.out.println("merge found at : " + head1.data); return; }
                head1 = head1.next;
                head2 = head2.next;
            }
        }
    }


    void display() {
        Node ptr = head;
        while (ptr != null) {
            System.out.print(ptr.data + " -> ");
            ptr = ptr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        //creating the 1st LL.
        Main l1 = new Main();
        l1.insert(10);l1.insert(20);l1.insert(30);l1.insert(40);
        l1.display();

        //creating the 2nd LL.
        Main l2 = new Main();
        l2.insert(100);l2.insert(200);l2.insert(300);l2.insert(400);
        l2.insert(500);l2.insert(600);l2.insert(700);
        l2.display();

        //merging the LL.
        mergeLL(l1.head, l2.head);
        l1.display();l2.display();

        //calling best possible solution.
        findIntersection_BestSolution(l1.head, l2.head);

    }
}
