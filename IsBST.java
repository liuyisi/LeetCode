/**
 * Created by liuyisi on 2018/2/21.
 */
public class IsBST {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * Classic Problem : corner case: root == null
     *                  Children node must strictly smaller or larger than root value
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        if (root == null)   return true;
        long max = Long.MAX_VALUE;
        long min = Long.MIN_VALUE;

        return helper(root.left, min, root.val) && helper(root.right, root.val, max);
    }
    private boolean helper (TreeNode root, long min, long max) {
        if (root == null) return true;
        boolean ans = root.val > min && root.val < max ? true : false;
        if (ans == false)   return false;
        else {
            boolean left = helper(root.left, min, root.val);
            boolean right = helper(root.right, root.val, max);
            return left && right;
        }
    }
}
