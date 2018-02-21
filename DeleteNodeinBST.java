
/**
 * Created by liuyisi on 2018/2/20.
 */
public class DeleteNodeinBST {
    private class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }
    public TreeNode deleteNode (TreeNode root, int key) {
        if (root == null)   return null;
        //find target node
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
            return root;
        }else if (key > root.val) {
            root.right = deleteNode(root.right, key);
            return root;
        }else {
            if (root.left == null) {
                root = root.right;
                return root;
            }else if (root.right == null) {
                root = root.left;
                return root;
            }else {
                //node right do not have left children which means itself is the smallest node, so just move it up
                if (root.right.left == null) {
                    root.right.left = root.left;
                    return root.right;
                }
                TreeNode smallest = delete (root.right);
                //connect the smallest node with root.left and root.right
                smallest.left = root.left;
                smallest.right = root.right;
                //return smallest node
                return smallest;
            }
        }
    }
    private TreeNode delete (TreeNode cur) {
        TreeNode prev = cur;
        cur = cur.left;
        while (cur.left != null) {
            prev = cur;
            cur = cur.left;
        }
        //cur is the smallest one and parent is its parent
        prev.left = prev.left.right;
        return cur;
    }
}
