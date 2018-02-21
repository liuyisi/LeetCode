/**
 * Created by liuyisi on 2018/2/21.
 */
public class RemoveAdjacentRepeatedCharacterIV {
    public String deDup(String input) {
        // Write your solution here
        if(input == null || input.length() == 1 || input.length() == 0) {
            return input;
        }
        char[] ch = input.toCharArray();
        //instead of using an extra stack explicitly, we can actually reuse the left side of the original char[]
        // as the "stack" end is where the top of the stack is
        int end = 0;
        for(int i = 1; i < ch.length; i++) {
            if(end == -1 || ch[i] != ch[end]){
                ch[++end] = ch[i];
            }else{
                //we need to pop the top element and ignore all later consective character
                end--;
                while(i + 1 < ch.length && ch[i] == ch[i + 1]){
                    i++;
                }
            }
        }
        return new String(ch, 0, end + 1);
    }
}
