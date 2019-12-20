package Algorithms.binary_strings;

public class Main {
    static int arr[] = new int[3];

    static void disp() {
        for(int i=0; i<3; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    static void binary_string(int n) {
        if(n < 1) {
            disp();
            System.out.println();
            return;
        } else {
            arr[n-1] = 0;
            binary_string(n-1);
            arr[n-1] = 1;
            binary_string(n-1);
        }
    }

    public static void main(String[] args) {
        Main.binary_string(3);
    }
}
