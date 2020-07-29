import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine());
      char[] arr = new char[n];
      int i=0; 
      while(n > 0) {
          char ch = (char)br.read();
          arr[i++] = ch;
      }
  }
}