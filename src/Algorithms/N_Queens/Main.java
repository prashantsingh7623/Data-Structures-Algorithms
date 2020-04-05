package Algorithms.N_Queens;

/* In below algorithm i've used backtracking approach using recursion.
* 1. I've created isSafe function to check whether the cell(i, j) is safe to explore.
* 2. And backtrack function which marks the cell visited if its safe. And while
* backtracking (recursion) we delete the last visited cell, so that it can explore remaining.
* Also we advance column_pointer(j) to explore new cells.
* Uncomment below lines to understand the recursion better.*/

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static boolean isSafe(int i, int j, int n, List<ArrayList<Integer>> visited) {
        if(i < 0 || i > n - 1 || j < 0 || j > n - 1) {
            //System.out.println(i + " " + j + " not safe");
            return false;
        }
        else {
            for (List<Integer> l : visited) {
                if(i == l.get(0) || j == l.get(1)) {
                    //System.out.println(i + " " + j + " not safe");
                    return false;
                }
                else if (((i - j) == ((l.get(0)) - (l.get(1)))) ||
                        ((i + j) == ((l.get(0)) + (l.get(1)))))
                {
                    //System.out.println(i + " " + j + " not safe");
                    return false;
                }
            }
            //System.out.println(i + " " + j + " is safe");
            return true;
        }
    }

    static void backTrack(int i, int j, int n,int[][] arr, List<ArrayList<Integer>> visited) {
        //System.out.println("back track with : " + i + " " + j);
        while (i < n && j < n) {
            if (isSafe(i, j, n, visited)) {
                arr[i][j] = 1;
                ArrayList<Integer> arrayList = new ArrayList<>();
                arrayList.add(i); arrayList.add(j);
                visited.add(arrayList);

                backTrack(i + 1, 0, n, arr, visited);
                visited.remove(visited.size() -1); //while backtracking removing last safe cell.
                arr[i][j] = 0; // making the last placed queen to 0.
                j ++; //incrementing j (column pointer) to explore new cells.
            } else {
                if (j != n-1) { j ++; }
                else { i ++; j = 0;}
            }
        }
        if (visited.size() == n) {
            System.out.print("Queens allotment : ");
            for(List<Integer> l : visited) {
                System.out.print(l.get(1) + 1 + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter no. of Queens : ");
        int n = scanner.nextInt();
        int[][] arr = new int[n][n];
        List<ArrayList<Integer>> visited = new ArrayList<>();
        backTrack(0, 0, n, arr, visited);
    }
}
