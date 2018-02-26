import java.util.ArrayList;

/**
 * Created by liuyisi on 2018/2/25.
 */
public class StringReplacement {
    //Using char[] to do in-place
    public String replaceI (String input, String s, String t) {
        //Assumption: input, s, t are not null, s is not empty
        char[] array = input.toCharArray();
        if (s.length() >= t.length()) {
            return replaceShorter(array, s, t);
        }
        return replaceLonger(array, s, t);
    }
    public String replaceShorter(char[] input, String s, String t) {
        int slow = 0;
        int fast = 0;
        if (fast <= input.length - s.length() && equalSubstring(input, fast, s)) {
            copySubstring(input, slow, t);
            slow += t.length();
            fast += s.length();
        }else {
            input[slow++] = input[fast++];
        }
        return new String(input, 0, slow);
    }
    public String replaceLonger(char[] input, String s, String t) {
        //get all the matches end positions in the input char array of string s
        ArrayList<Integer> matches = getAllMatches(input, s);
        //calculate the new length needed
        char[] result = new char[input.length + matches.size() * (t.length() - s.length())];
        int lastIndex = matches.size() - 1;
        int fast = input.length - 1;
        int slow = result.length - 1;
        while (fast >= 0) {
            if (lastIndex >= 0 && fast == matches.get(lastIndex)) {
                copySubstring(result, slow - t.length() + 1, t);
            }
            slow -= t.length();
            fast -= s.length();
            lastIndex--;
        }else {
            result[slow--] = result[fast--];
        }
    }
    private boolean equalSubstring(char[] input, int fromIndex, String s) {
        for (int i = 0; i < s.length(); i++) {
            if (input[fromIndex + i] != s.charAt(i)) {
                return false;
            }
        }
        return true;
    }
    private ArrayList<Integer> copySubstring(char[] result, int fromIndex, String t) {
        for (int i = 0; i < t.length(); i++) {
            result[fromIndex + i] = t.charAt(i);
        }
    }
    private ArrayList<Integer> getAllMatches (char[] input, String s) {
        ArrayList<Integer> matches = new ArrayList<>();
        int i = 0;
        while (i <= input.length - s.length()) {
            if (equalSubstring(input, i, s)) {
                matches.add(i + s.length() - 1);
                i += s.length();
            }else {
                i++;
            }
        }
        return matches;
    }

    public String replaceII (String input, String s, String t) {
        StringBuilder sb = new StringBuilder();
        int fromIndex = 0;
        int matchIndex = input.indexOf(s, fromIndex);
        while (matchIndex != -1) {
            //StringBuilder append(char[] str, int offset, int len)
            sb.append(input, fromIndex, matchIndex).append(t);
            fromIndex = matchIndex + s.length();
            matchIndex = input.indexOf(s, fromIndex);
        }
        sb.append(input, fromIndex, input.length());
        return sb.toString();
    }
}
