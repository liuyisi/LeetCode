import java.util.*;
/**
 * Created by liuyisi on 2018/2/21.
 */
public class RemoveCertainClass {
    public String remove(String input, String t) {
        // Write your solution here
        char[] ch = t.toCharArray();
        Set<Character> set = new HashSet<Character>();
        for (int i = 0; i < ch.length; i++) {
            set.add(ch[i]);
        }
        char[] in = input.toCharArray();
        //slow and fast pointer
        int i = 0, j = 0;
        while(j < in.length) {
            if(!set.contains(in[j])) {
                in[i++] = in[j++];
            }else{
                j++;
            }
        }
        //convert the char[] subarray back to String Object
        //Refer to java API doc for applicable constructor !!!
        return new String(in, 0, i);
    }
}
