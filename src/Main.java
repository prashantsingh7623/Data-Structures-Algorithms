import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<ArrayList<Integer>> lists = new ArrayList<>();
        ArrayList<Integer> arrayList = null;
        for (int i=0; i<3; i++) {
            arrayList = new ArrayList<>();
            arrayList.add(i);
            arrayList.add(i + 2);
            lists.add(arrayList);
        }
        System.out.println(lists);
        lists.remove(lists.size() -1);
        Stream.of(lists)
                .flatMap(Stream::of)
                .forEach(System.out::println);
    }
}