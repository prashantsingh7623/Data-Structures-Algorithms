package Algorithms.strings.group_anagrams;

import java.util.Map;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
  public static void main (String[] args) throws IOException{
		//code
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<String> list, newList;
		int t = Integer.parseInt(br.readLine());
		while(t > 0) {
		    list = new ArrayList<>();
		    Map<String, List<String>> map = new HashMap<>();
		    int n = Integer.parseInt(br.readLine());
		    String[] str = br.readLine().split(" ");
		    
		    for(int i=0; i<n; i++) {
		        char[] ch = str[i].toCharArray();
		        Arrays.sort(ch);
		        if(!map.containsKey(new String(ch))) {
		            newList = new ArrayList<>();
		            newList.add(str[i]);
		            map.put(new String(ch), newList);
		        } else {
		            list = map.get(new String(ch));
		            list.add(str[i]);
		            map.put(new String(ch), list);
		        }
		    }
		    List<Integer> l = new ArrayList<>();
		    map.forEach((key, val) -> l.add(map.get(key).size()));
		    Collections.sort(l);
		    for(int i:l)
		        System.out.print(i + " ");
		    
		    t -= 1;
		    System.out.println();
		}
	}
}