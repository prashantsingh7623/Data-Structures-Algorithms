package Algorithms.factorial;

public class Main {
    static int fact(int n) {
        if(n <= 1) { System.out.println("in return") ;return 1; }
        System.out.println("before function call");
        int a=  n * fact(n-1);
        System.out.println("after a");
        a += 2;
        System.out.println("a added");
        return a;
    }

    public static void main(String[] args) {
        System.out.println(fact(4));
    }
}
