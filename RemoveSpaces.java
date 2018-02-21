/**
 * Created by liuyisi on 2018/2/21.
 */
public class RemoveSpaces {
    public String removeSpaces(String input) {
        // Write your solution here
        //remove leading and trailing spaces
        input = input.trim();
        char[] ch = input.toCharArray();
        int slow = 0, fast = 0;
        while(fast < ch.length) {
            if(fast > 0 && ch[fast] == ' ' && ch[fast - 1] != ' '){
                ch[slow++] = ch[fast++];
            }
            if(fast > 0 && ch[fast] == ' ' && ch[fast - 1] == ' '){
                fast++;
            }
            if(ch[fast] != ' '){
                ch[slow++] = ch[fast++];
            }
        }
        return new String(ch, 0, slow);
    }
}
