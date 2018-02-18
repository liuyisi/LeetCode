/**
 * Created by liuyisi on 2018/2/17.
 */

//DP time: O(n ^ 2)  space: O(n ^ 2)
public class longestPalindromicSubstring {
    public String longestPalindrome (String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        String ans = "";
        boolean[][] dp = new boolean[s.length()][s.length()];
        int max = 0;
        for (int j = 0; j < s.length(); j++) {
            for (int i = 0; i <= j; i++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i <= 2 || dp[i + 1][j - 1]);
                if (dp[i][j]) {
                    if (j - i + 1 > max) {
                        max = j - i + 1;
                        ans = s.substring(i, j + 1);
                    }
                }
            }
        }
        return ans;
    }
}
