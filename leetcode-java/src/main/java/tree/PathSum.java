package tree;

/**
 * <pre>
 * 112. 路径总和。
 * https://leetcode-cn.com/problems/path-sum/。
 * </pre>
 *
 * @author Yishen 844147804@qq.com
 * @version 1.00.00
 */
public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        return this.findPathSum(root, sum, 0);
    }

    public boolean findPathSum(TreeNode node, int sum, int curSum) {
        curSum += node.val;
        if (curSum == sum && node.left == null && node.right == null) {
            return true;
        }

        boolean flag = false;

        if (node.left != null) {
            flag = this.findPathSum(node.left, sum, curSum);
            if (flag) return true;
        }
        if (node.right != null) {
            flag = this.findPathSum(node.right, sum, curSum);
            if (flag) return true;
        }
        return flag;
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
