package Algorithms.tower_of_hanoi;

//algorithm
/*
* 1. Move (n-1) disks from source to auxiliary tower.
* 2. Move nth disks from source to destination tower.
* 3. Move (n-1) disks form auxiliary tower to destination tower.
* Total number of moves required : pow(2,n) - 1.
* */

public class Main {

    static void toi(int n, char from_rod, char to_rod, char aux_rod) {
        if(n == 1) {
            System.out.println("Move disks 1 from " + from_rod + " to " + to_rod);
            return;
        }
        toi(n-1, from_rod, aux_rod, to_rod);
        System.out.println("move disk " + n + " from " + from_rod + " to " + to_rod);
        toi(n-1, aux_rod, to_rod, from_rod);
    }

    public static void main(String[] args) {
        Main.toi(3,'A','C','B');
    }
}