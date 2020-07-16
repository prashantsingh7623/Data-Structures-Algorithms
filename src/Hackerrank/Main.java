package Hackerrank;

import java.util.Scanner;
class Main {
    public static void main(String[] args) {
        System.out.println("Enter total data elements: ");
        int total;
        Scanner sc = new Scanner(System.in);
        total = sc.nextInt();
        double[] setA = new double[total];
        double[] setB = new double[total];
        double[] denominator = new double[total];
        double[] result = new double[total];
        System.out.println("Enter denominatorinator values: ");
        for (int i = 0; i < total; i++) {
            denominator[i] = sc.nextDouble();
        }
        System.out.println("Enter values of Set A and Set B for each denominatorinator value: ");
        for (int i = 0; i < total; i++) {
            System.out.print("A[" + i + "]: ");
            setA[i] = sc.nextDouble();
            System.out.print(" B[" + i + "]: ");
            setB[i] = sc.nextDouble();
            System.out.println();
        }
        int ch = 0;
        do {
            System.out.println("1. A U B\n2. A ^ B\n3. ~uA\n4. ~uB\n5. ~(A U B)\n6. " +
                    "~(A ^ B)\n7. ~A U ~B\n8. ~A ^ ~B\n" +
                    "9. A U ~A\n10. B U ~B\n11. Exit\n");
            System.out.println("Select Operation:");
            ch = sc.nextInt();
            switch (ch) {
                case 1:
                    for (int i = 0; i < total; i++) {
                        result[i] = Math.max(setA[i], setB[i]);
                        System.out.print(result[i] + " ");
                    }
                    System.out.println();
                    break;
                case 2:
                    for (int i = 0; i < total; i++) {
                        result[i] = Math.min(setA[i], setB[i]);
                        System.out.print(result[i] + " ");
                    }
                    System.out.println();
                    break;
                case 3:
                    for (int i = 0; i < total; i++) {
                        result[i] = 1 - setA[i];
                        System.out.print(result[i] + " ");
                    }
                    System.out.println();
                    break;
                case 4:
                    for (int i = 0; i < total; i++) {
                        result[i] = 1 - setB[i];
                        System.out.print(result[i] + " ");
                    }
                    System.out.println();
                    break;
                case 5:
                    for (int i = 0; i < total; i++) {
                        result[i] = 1 - (Math.max(setA[i], setB[i]));
                        System.out.print(result[i] + " ");
                    }
                    System.out.println();
                    break;
                case 6:
                    for (int i = 0; i < total; i++) {
                        result[i] = 1 - (Math.min(setA[i], setB[i]));
                        System.out.print(result[i] + " ");
                    }
                    System.out.println();
                    break;
                case 7:
                    for (int i = 0; i < total; i++) {
                        result[i] = Math.max(setA[i], (1 - setB[i]));
                        System.out.print(result[i] + " ");
                    }
                    System.out.println();
                    break;
                case 8:
                    for (int i = 0; i < total; i++) {
                        result[i] = Math.min(setA[i], (1 - setB[i]));
                        System.out.print(result[i] + " ");
                    }
                    System.out.println();
                    break;
                case 9:
                    for (int i = 0; i < total; i++) {
                        result[i] = Math.max(setA[i], (1 - setA[i]));
                        System.out.print(result[i] + " ");
                    }
                    System.out.println();
                    break;
                case 10:
                    for (int i = 0; i < total; i++) {
                        result[i] = Math.max(setB[i], (1 - setB[i]));
                        System.out.print(result[i] + " ");
                    }
                    System.out.println();
                    break;
                case 11:
                    sc.close();
                    break;
            }
        } while (ch != 11);
    }
}