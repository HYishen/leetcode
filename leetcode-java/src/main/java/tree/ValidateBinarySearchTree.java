package tree;

/**
 * <pre>
 * 验证二叉搜索树。
 * https://leetcode-cn.com/problems/validate-binary-search-tree/
 * </pre>
 *
 * @author Yishen 844147804@qq.com
 * @version 1.00.00
 */
public class ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        return this.validateBST(root, Long.MAX_VALUE, Long.MIN_VALUE);
    }

    public boolean validateBST(TreeNode node, long max, long min) {
        if (node.left == null && node.right == null) return true;

        boolean flag = true;

        if (node.left != null) {
            if (node.left.val >= node.val || node.left.val <= min) return false;
            flag = this.validateBST(node.left, node.val, min);
            if (!flag) return false;
        }
        if (node.right != null) {
            if (node.right.val <= node.val || node.right.val >= max) return false;
            flag = this.validateBST(node.right, max, node.val);
            if (!flag) return false;
        }
        return true;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
