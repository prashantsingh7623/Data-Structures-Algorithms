package coursera.gcd;

/*
* if d divides both a and b
* than it also divides both a' and b (a-prime and b).
* since, a = a' + bq where, a' is remainder.
* this is GCD lemma.
https://www.khanacademy.org/computing/computer-science/cryptography/modarithmetic/a/the-euclidean-algorithm
*
* a x b = LCM(a, b) * GCD (a, b)

   LCM(a, b) = (a x b) / GCD(a, b)
   *
* */

public class Main {
    static int findGCD(int a, int b) {
        if (b==0) { return a; }
        int rem = a % b;
        return findGCD(b, rem);
    }

    static int lcm(int a, int b) {
        return (a * b) / findGCD(a, b);
    }

    public static void main(String[] args) {
        System.out.println(findGCD(10, 4));
        System.out.println(lcm(10, 4));
    }

}
