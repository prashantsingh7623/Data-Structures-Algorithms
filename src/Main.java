import java.util.SortedSet;
import java.util.TreeSet;

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
    public static void main(String[] args) {
        SortedSet<Integer> set = new TreeSet<>();
        set.add(129);set.add(756);set.add(4);set.add(943);
        for (int i : set) {
            System.out.println(i);
        }
        int firstEle = set.stream().findFirst().get();
        head = new Node(firstEle);
        set.remove(firstEle);
        Node ptr = head;
        for (int i : set) {
            head.next = new Node(i);
            head = head.next;
        }
        while (ptr != null) {
            System.out.print(ptr.data + " -> ");
            ptr = ptr.next;
        }
    }
}