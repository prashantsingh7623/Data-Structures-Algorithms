import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    static int countAnagrams(String str) {
        int count = 0;
        String s = null;
        Map<String, Integer> map = new HashMap<>();
        for (int i=0; i<str.length(); i++) {
            s = "";
            for (int j=i+1; j<str.length() + 1; j++) {
                s = str.substring(i,j);
                char[] temp = s.toCharArray(); //converting the string into char array
                Arrays.sort(temp);
                s = String.copyValueOf(temp); //again converting the string into array.
                if (!map.containsKey(s)) { map.put(s, 1); }
                else { map.replace(s, map.get(s) + 1); }
            }
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            count += (entry.getValue() * (entry.getValue() - 1) / 2);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countAnagrams("mom"));
    }
}