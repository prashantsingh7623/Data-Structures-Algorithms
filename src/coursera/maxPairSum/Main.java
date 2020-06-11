package coursera.maxPairSum;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static long maxPairSum(int[] arr, int n) {
        int maxNum1 = -1;
        for (int i=0; i<n; i++) {
            if (maxNum1 == -1 || (arr[i] > arr[maxNum1])) {
                maxNum1 = i;
            }
        }

        int maxNum2 = -1;
        for (int i=0; i<n; i++) {
            if ((i != maxNum1) && ((maxNum2 == -1) || (arr[i] > arr[maxNum2]))) {
                maxNum2 = i;
            }
        }

        return (long)arr[maxNum1] * arr[maxNum2];
    }

    public static void main(String[] args) {
        int n;
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i=0; i< n; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println(Arrays.toString(arr));

        System.out.println(maxPairSum(arr, n));
    }
}
