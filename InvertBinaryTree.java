/**
 * Created by liuyisi on 2018/2/20.
 */
public class InvertBinaryTree {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * 这道题虽然简单，但是在传参方面还是要注意
     * 不能直接改变left和right，应该改变的是root.left和root.right
     *因为如果把left和right当作参数传递后，虽然指向的是原树中的left和right，但是如果使用left = right这样，
     *参数会变成指向了right，但当函数结束后，原树中的left并没有变化。但如果对root.left和root.right就是对原树中的结点进行了修改
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
