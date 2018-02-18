import java.util.*;
/**
 * Created by liuyisi on 2018/2/17.
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            int count[] = new int[26];
            char[] ch = str.toCharArray();
            for (char c : ch) {
                count[c - 'a']++;
            }
            String s = "";
            for (int i = 0; i < count.length; i++) {
                s += String.valueOf(count[i]) + String.valueOf(i);
            }
            if (map.containsKey(s)) {
                List<String> list = map.get(s);
                list.add(str);
            }else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(s, list);
            }
        }
        return new ArrayList<>(map.values());
    }
}
