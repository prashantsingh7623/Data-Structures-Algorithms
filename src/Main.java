import java.util.Arrays;

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
        Integer i = null;
        System.out.println(i);

        int[] arr = {1,2,3};
        System.out.println(Arrays.toString(arr));
    }
}
