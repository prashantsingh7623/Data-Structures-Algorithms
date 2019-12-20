package Algorithms.fibonacci_series.using_forLoop;

public class Main {

    static void fib(int n) {
        int prev = 0, next = 1;
        System.out.print("Fibonacci series : ");
        for(int i =0; i<n; i++) {
            System.out.print(prev + " ");
            int sum = prev + next;
            prev = next;
            next = sum;
        }
    }

    public static void main(String[] args) {
        Main.fib(6);
    }
}
