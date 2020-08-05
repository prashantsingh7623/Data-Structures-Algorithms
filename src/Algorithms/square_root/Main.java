package Algorithms.square_root;

public class Main {
  public static double squareRoot(double number) {
    int i=1;
    while(true) {
      if (i*i == number) { return i; }
      else if(i * i > number) { return _squareRoot(number, i-1, i); }
      i += 1;
    }
  }

  private static double _squareRoot(double number, double i, double j) {
    double mid = (i + j) / 2;
    double square = mid * mid;
    if (square == number || Math.abs(square-number)<0.0000001) { return mid; }
    else if(square > number) { return _squareRoot(number, i, mid); }
    else { return _squareRoot(number, mid, j); }
  }
  public static void main(String[] args) {
    System.out.println(squareRoot(11));
  }
}