package Algorithms.Arrays.find_duplicate_in_array;

//https://www.youtube.com/watch?v=pKO9UjSeLew

public class Main {
    public static int findDuplicate(int[] arr) {
        int tortoise = arr[0], hare = arr[0];
        do {
            tortoise = arr[tortoise];
            hare = arr[arr[hare]];
        } while (tortoise != hare);

        return tortoise;
    }

    public static void main(String[] args) {
        int[] arr = {3,1,3,4,5,3,2};
        System.out.println(findDuplicate(arr));
    }
}
