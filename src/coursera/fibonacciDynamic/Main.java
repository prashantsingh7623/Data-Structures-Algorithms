package coursera.fibonacciDynamic;

import java.math.BigInteger;

//https://www.geeksforgeeks.org/sum-of-fibonacci-numbers-in-a-range/

public class Main {
    static BigInteger findFib(int n) {
        BigInteger f0 = new BigInteger(String.valueOf(0));
        BigInteger f1 = new BigInteger(String.valueOf(1));;
        BigInteger tot = new BigInteger(String.valueOf(0));;
        while(n-- > 2) {
            tot = tot.add(f0.add(f1));
            f0 = f1;
            f1 = tot;
        }
        return tot;
    }

    static int fib(int n) {
        double phi = (1 + Math.sqrt(5)) / 2;
        return (int)Math.round(Math.pow(phi, n) / Math.sqrt(5));
    }

    static int sumOfFibInRange(int l, int r) {
        return fib(r+2) - fib(l+1);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(findFib(1000));
    }
}
