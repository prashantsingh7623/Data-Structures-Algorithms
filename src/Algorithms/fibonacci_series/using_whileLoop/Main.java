package Algorithms.fibonacci_series.using_whileLoop;

public class Main {

    static void fib(int n) {
        int prev = 0, next = 1;
        System.out.println("FS : ");
        while(n > 0) {
            System.out.print(prev + " ");
            int sum = prev + next;
            prev = next;
            next = sum;
            n--;
        }
    }

    public  static void main(String[] abc) {
        Main.fib(6);
    }
}
