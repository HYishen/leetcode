package tree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <pre>
 * 二叉树最大深度。
 * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 * </pre>
 *
 * @author Yishen 844147804@qq.com
 * @version 1.00.00
 */
public class MaximumDepthOfBinaryTree {

    // 递归解法
    public int maxDepth1(TreeNode root) {
        if (root == null) return 0;

        int[] maxDeep = new int[1];
        maxDeep[0] = 1;

        this.findMaxDeep1(root, 1, maxDeep);

        return maxDeep[0];
    }

    public void findMaxDeep1(TreeNode node, int deep, int[] maxDeep) {
        if (node.left == null && node.right == null) {
            maxDeep[0] = Math.max(deep, maxDeep[0]);
        }
        if (node.left != null) {
            this.findMaxDeep1(node.left, deep + 1, maxDeep);
        }
        if (node.right != null) {
            this.findMaxDeep1(node.right, deep + 1, maxDeep);
        }
    }

    // 用堆和循环代替递归
    public int maxDepth2(TreeNode root) {
        if (root == null) return 0;

        Deque<TreeNode> nodeStack = new ArrayDeque<>();
        Deque<Integer> deepStack = new ArrayDeque<>();

        nodeStack.addLast(root);
        deepStack.addLast(1);

        int maxDeep = 1;

        while (!nodeStack.isEmpty()) {
            TreeNode node = nodeStack.pollLast();
            Integer deep = deepStack.pollLast();

            if (node.left == null && node.right == null) {
                maxDeep = Math.max(deep, maxDeep);
            }

            if (node.left != null) {
                nodeStack.addLast(node.left);
                deepStack.addLast(deep + 1);
            }

            if (node.right != null) {
                nodeStack.addLast(node.right);
                deepStack.addLast(deep + 1);
            }
        }

        return maxDeep;
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
