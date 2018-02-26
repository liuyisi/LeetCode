import java.util.*;
/**
 * Created by liuyisi on 2018/2/26.
 */
public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new LinkedList<>();
        for (String s : tokens) {
            if (s.equals("+")) {
                stack.offerLast(stack.pollLast() + stack.pollLast());
            }else if (s.equals("-")) {
                int temp = stack.pollLast();
                stack.offerLast(stack.pollLast() - temp);
            }else if (s.equals("*")) {
                stack.offerLast(stack.pollLast() * stack.pollLast());
            }else if (s.equals("/")) {
                int temp = stack.pollLast();
                stack.offerLast(stack.pollLast() / temp);
            }else {
                stack.offer(Integer.parseInt(s));
            }
        }
        return stack.pollLast();
    }
}
