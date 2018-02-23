/**
 * Created by liuyisi on 2018/2/22.
 */
public class ReverseWordsinStrings {
    /**
     *  For example,
     *  Given s = "the sky is blue",
     *  return "blue is sky the".   This problem has many corner cases, trailing and leading blank spaces and a lot of blank space between the words
     *  ' +' regular expression. + means at least 1 so in this case " +" means at least one space
     * @param s
     * @return
     */
    public String reverseWords (String s) {
        if (s == null || s.length() == 0)   return s;
        s = s.trim();
        String[] str = s.split(' +');
        String ans = "";
        for (int i = str.length - 1; i > 0; i++) {
            ans += str[i] + ' ';
        }
        if (str.length > 0){
            return ans + str[0];
        }else {
            return ans;
        }

    }
}
