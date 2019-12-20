package Algorithms.fibonacci_series.using_recursion;

/*
Finding the fibonacci number at specific place.
* ex : find fibonacci number at 6 place.
* ex : find fibonacci number at 0 place.
* ex : find fibonacci number at 1 place.
* ex : find fibonacci number at 2 place.
*/

public class Main {
    static int genFibonacci(int n) {
        if(n <=1) { return n;}
        return genFibonacci(n - 1) + genFibonacci(n - 2);
    }

    public static void main(String[] abc) {
        System.out.println("Fibonacci number at 6" + " place is : " + Main.genFibonacci(6));
        System.out.println("printing the fibonacci series : ");
        for(int i=0; i<6; i++) {
            System.out.print(Main.genFibonacci(i) + " ");
        }
    }
}
