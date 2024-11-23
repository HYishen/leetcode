package dynamic;

/**
 * <pre>
 * https://leetcode-cn.com/problems/jian-sheng-zi-lcof/。
 * </pre>
 *
 * @author huangyishen yishen.huang@meicloud.com
 * @version 1.00.00
 */
public class JianShengZiLcof {

    /**
     * 状态转移方程：求长度为i的绳子的最大值。我们可以选择先剪一段长度为j的绳子，那么绳子剩下的长度为i-j。
     * 剩下绳子，我们可以选择剪，或者不剪。那么当前阶段的最大乘积即为max(j * (i - j), j * dp[i - j])
     * <p>
     * 最优子结构：dp[i] 可以根据 max(j * (i - j), j * dp[i - j])确定，其中 max(j * (i - j), j * dp[i - j]) 公式要算 i - 2遍，然后取最大值
     *
     * @return int
     * @Param [n]
     */
    public int cuttingRope(int n) {
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 2; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }

        return dp[n];
    }

}
