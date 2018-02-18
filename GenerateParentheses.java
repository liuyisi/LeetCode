import java.util.*;
/**
 * Created by liuyisi on 2018/2/17.
 */
public class GenerateParentheses {
    public List<String> generateParenthesis (int n) {
        List<String> ans = new ArrayList<>();
        if (n == 0) {
            return ans;
        }
        StringBuilder prefix = new StringBuilder();
        helper(ans, n, 0, 0, prefix);
        return ans;
    }

    private void helper (List<String> ans, int n, int l, int r, StringBuilder prefix) {
        if (l == n && r == n) {
            String s = prefix.toString();
            ans.add(s);
            return;
        }
        //case 1 : add '('
        if (l < n) {
            prefix.append('(');
            helper(ans, n, l + 1, r, prefix);
            prefix.deleteCharAt(prefix.length() - 1);
        }
        //case 2 : add ')'
        if (r < l) {
            prefix.append(')');
            helper(ans, n, l, r + 1, prefix);
            prefix.deleteCharAt(prefix.length() - 1);
        }
    }
}
