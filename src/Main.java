import java.util.Arrays;
import java.util.List;

public class Main {
    public static void temp() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        Integer[] integers =  new Integer[numbers.size()];
        numbers.toArray(integers);
        System.out.println(Arrays.toString(integers));
    }

    public static void main(String[] args) {
        temp();
    }
}