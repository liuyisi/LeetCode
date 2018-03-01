import java.util.*;
/**
 * Created by liuyisi on 2018/2/23.
 */
public class LetterCombinationofPhoneNumber {
    private static final String[] KEYS = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations (String digits) {
        List<String> ans = new ArrayList<String>();
        if (digits == null || digits.length() == 0) {
            ans.add("");
            return ans;
        }
        StringBuilder sb = new StringBuilder();
        helper(digits, 0, ans, sb);
        return ans;
    }
    private void helper (String digits, int index, List<String> ans, StringBuilder prefix) {
        if (index == digits.length()) {
            String s = prefix.toString();
            ans.add(s);
            return;
        }
        int num = digits.charAt(index) - '0';
        for (int i = 0; i < KEYS[num].length(); i++) {
            prefix.append(KEYS[num].charAt(i));
            helper(digits, index + 1, ans, prefix);
            prefix.deleteCharAt(prefix.length() - 1);
        }
    }
}
