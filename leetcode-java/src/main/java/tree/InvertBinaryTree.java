package tree;

/**
 * https://leetcode-cn.com/problems/invert-binary-tree/
 */
public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        this.invert(root);
        return root;
    }

    public void invert(TreeNode node) {
        if (node.left == null && node.right == null) return;

        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;

        if (node.left != null) invert(node.left);
        if (node.right != null) invert(node.right);

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
