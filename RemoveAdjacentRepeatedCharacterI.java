/**
 * Created by liuyisi on 2018/2/21.
 */
public class RemoveAdjacentRepeatedCharacterI {
    public String deDup(String input) {
        // Write your solution here
        if(input == null) return null;
        char[] ch = input.toCharArray();
        int slow = 0, fast = 0;
        //It is better to use for loop, if adopting while loop, after entering one if block without continue it cannot check whether
        //its scope is out of bound
        while (fast < ch.length) {
            if(fast == 0){
                ch[slow++] = ch[fast++];
                continue;
            }
            if(fast > 0 && ch[fast] == ch[fast - 1]){
                fast++;
                continue;
            }
            if(fast > 0 && ch[fast] != ch[fast - 1]){
                ch[slow++] = ch[fast++];
                continue;
            }
        }
        return new String(ch, 0, slow);
    }
}
