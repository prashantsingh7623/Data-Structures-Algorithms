package Algorithms.Arrays.biginteger_factorial;

import java.math.BigInteger;
public class Main {
  static BigInteger fact(int n) {
    BigInteger bi = new BigInteger("1");
    while(n > 0) {
      bi = bi.multiply(BigInteger.valueOf(n));
      n -= 1;
    }
    return bi;
  }

  public static void main(String[] args) {
    System.out.println(fact(100));
  }
}