import java.util.*;
/**
 * Created by liuyisi on 2018/2/19.
 */
public class CheckisCompleteBinaryTree {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean isCompleted(TreeNode root) {
        if (root == null)   return true;
        //Queue initialization
        Queue<TreeNode> queue = new LinkedList<>();
        // if the flag is set true, there should not be any child children afterwards
        boolean flag = false;
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur.left == null) {
                flag = true;
            } else if (flag) {
                return false;
            } else {
                queue.offer(cur.left);
            }

            if (cur.right == null) {
                flag = true;
            } else if (flag) {
                return false;
            } else {
                queue.offer(cur.right);
            }
        }
        return true;
    }
}
