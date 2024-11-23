package queue;

import java.util.ArrayDeque;

/**
 * <pre>
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 *
 * 返回滑动窗口中的最大值。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sliding-window-maximum
 * </pre>
 *
 * @author Yishen 844147804@qq.com
 * @version 1.00.00
 */
public class SlidingWindowMaximum {
    ArrayDeque<Integer> deq = new ArrayDeque<Integer>();
    int[] nums;

    public void cleanDeque(int i, int k) {
        // 如果最大值的下标刚好是当前滑块最左下标-1，则去掉这个值
        if (!deq.isEmpty() && deq.getFirst() == i - k) {
            deq.removeFirst();
        }
        // 如果将要加入的值要大于队列尾的值，那这些值已经不需要了
        while (!deq.isEmpty() && nums[deq.getLast()] < nums[i]) {
            deq.removeLast();
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n * k == 0) return new int[0];
        if (k == 1) return nums;

        this.nums = nums;
        // 初始化队列，使其包含滑块开始时的最大值
        for (int i = 0; i < k; i++) {
            this.cleanDeque(i, k);
            deq.addLast(i);
        }
        int[] result = new int[n - k + 1];
        result[0] = nums[deq.getFirst()];
        // 滑动滑块，并不断计算出当前位置的最大值
        for (int i = k; i < n; i++) {
            this.cleanDeque(i, k);
            deq.addLast(i);
            result[i - k + 1] = nums[deq.getFirst()];
        }
        return result;
    }
}
