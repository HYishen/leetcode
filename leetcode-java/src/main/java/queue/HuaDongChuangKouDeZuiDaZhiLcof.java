package queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * <pre>
 * https://leetcode-cn.com/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof/。
 * </pre>
 *
 * @author Yishen 844147804@qq.com
 * @version 1.00.00
 */
public class HuaDongChuangKouDeZuiDaZhiLcof {

    /**
     * 暴力解法
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }
        if (k == 1) {
            return nums;
        }

        int[] res = new int[nums.length - k + 1];

        for (int i = 0, j = k - 1; i < res.length; i++, j++) {
            res[i] = findMax(nums, i, j);
        }

        return res;
    }

    private int findMax(int[] arr, int start, int end) {
        int max = Integer.MIN_VALUE;
        for (int i = start; i <= end; i++) {
            if (arr[i] >= max) {
                max = arr[i];
            }
        }
        return max;
    }

    /**
     * 队列解法
     */
    public int[] maxSlidingWindow2(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }
        if (k == 1) {
            return nums;
        }

        int[] res = new int[nums.length - k + 1];
        Deque<Integer[]> ad = new ArrayDeque<>(k + 1);
        for (int i = 0; i < nums.length; i++) {
            this.handleDeque(ad, new Integer[]{nums[i], i});
            if (i >= k) {
                // 检查当前队头元素是否需要清除
                if ((ad.peekFirst()[0] == nums[i - k]) && (ad.peekFirst()[1] == i - k)) {
                    ad.removeFirst();
                }
            }
            if (i >= k - 1) {
                res[i - k + 1] = ad.peekFirst()[0];
            }
        }

        return res;
    }

    /**
     * 处理双端队列，保持队列从小到大排序
     */
    private void handleDeque(Deque<Integer[]> deque, Integer[] inVal) {
        while (!deque.isEmpty()) {
            if (deque.peekLast()[0] <= inVal[0]) {
                deque.removeLast();
            } else {
                break;
            }
        }
        deque.addLast(inVal);
    }

    /** 官方答案 */
    public int[] maxSlidingWindow3(int[] nums, int k) {
        if (nums.length == 0 || k == 0) return new int[0];
        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        // 未形成窗口
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && deque.peekLast() < nums[i])
                deque.removeLast();
            deque.addLast(nums[i]);
        }
        res[0] = deque.peekFirst();
        // 形成窗口后
        for (int i = k; i < nums.length; i++) {
            if (deque.peekFirst() == nums[i - k])
                deque.removeFirst();
            while (!deque.isEmpty() && deque.peekLast() < nums[i])
                deque.removeLast();
            deque.addLast(nums[i]);
            res[i - k + 1] = deque.peekFirst();
        }
        return res;
    }
}
