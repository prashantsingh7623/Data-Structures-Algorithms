package Algorithms.Heaps.MaxHeap;

import java.util.ArrayList;
import java.util.NoSuchElementException;

class MaxHeap<T extends Comparable<T>> {
    private ArrayList<T> list;
    public MaxHeap() {
        list = new ArrayList<T>();
    }

    void shiftUp() {    //insertion
        int k = list.size() - 1;
        while (k > 0) {
            int p = (k-1) / 2;
            T item = list.get(k);
            T parent = list.get(p);

            if (item.compareTo(parent) > 0) {
                //swap
                list.set(k, parent);
                list.set(p, item);

                //move pointer to parent
                k = p;
            } else {
                break;
            }
        }
    }

    void shiftDown() {  //deletion
        int k=0;
        int _leftChild = 2 * k + 1;
        while(_leftChild < list.size()) {
            int max = _leftChild, _rightChild = _leftChild + 1;
            if (_rightChild < list.size()) {
                if (list.get(_rightChild).compareTo(list.get(_leftChild)) > 0) {
                    max++;
                }
            }
            if (list.get(k).compareTo(list.get(max)) < 0) {
                //swap
                T temp = list.get(k);
                list.set(k, list.get(max));
                list.set(max, temp);

                k = max;
                _leftChild = 2 * k + 1;
            } else {
                break;
            }
        }
    }

    public void insert(T item) {
        list.add(item);
        shiftUp();
    }

    public T delete() throws NoSuchElementException {
        if (list.size() == 0) { throw new NoSuchElementException(); }
        if (list.size() == 1) { return list.remove(0); }
        T val = list.get(0);
        list.set(0, list.remove(list.size() - 1));
        shiftDown();
        return val;
    }

    public String toString() {
        return list.toString();
    }
}


public class Main {
    public static void main(String[] args) {
        MaxHeap<Integer> maxHeap = new MaxHeap<>();
        maxHeap.insert(10);
        maxHeap.insert(15);
        maxHeap.insert(20);
        maxHeap.insert(30);
        maxHeap.delete();
        maxHeap.delete();
        maxHeap.delete();
        System.out.println(maxHeap.toString());
    }
}
