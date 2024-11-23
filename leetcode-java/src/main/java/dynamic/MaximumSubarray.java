package dynamic;

/**
 * <pre>
 * https://leetcode-cn.com/problems/maximum-subarray/。
 * </pre>
 *
 * @author Yishen 844147804@qq.com
 * @version 1.00.00
 */
public class MaximumSubarray {

    /**
     * 多阶段决策模型：求第i个下标结尾的数组的最大值
     * 最优子结构：如果以i-1为下标结尾的数组的最大值是pre，那么以i为下标结尾的数组的最大值就是max(pre + x, x)
     * 无后效性：我们只需要关心以i-1为下标结尾的数组的最大值即可，无需关心他是怎么来的。
     * <p>
     * 最后解答：求以0到n-1结尾为下标的数组的最大值
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int res = nums[0];

        int pre = 0;

        for (int i = 0; i < nums.length; i++) {
            pre = Math.max(pre + nums[i], nums[i]);
            res = Math.max(pre, res);
        }

        return res;
    }

}
