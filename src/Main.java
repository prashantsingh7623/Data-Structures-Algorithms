import java.io.*;

class Try {
  protected void foo() { System.out.println("foo try is called...!");}
}

public class Main extends Try{

  public void foo() { System.out.println("foo try is called...!");}
    public static void main(String[] args){
      String s1 = "abc";
		String s2 = "abc";
		System.out.println("s1 == s2 is:" + s1 == s2);
  }

  public static void main() {

  }
}