package dynamic;

/**
 * <pre>
 * https://leetcode-cn.com/problems/unique-paths/。
 * </pre>
 *
 * @author Yishen 844147804@qq.com
 * @version 1.00.00
 */
public class UniquePaths {

    /**
     * 动态转移方程：f(m,n) = f(m-1,n) + f(m,n-1)
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {

        int[][] status = new int[m][n];
        // 初始化二维表
        status[0][0] = 1;
        for (int i = 1; i < n; i++) {
            status[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            status[i][0] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                status[i][j] = status[i - 1][j] + status[i][j - 1];
            }
        }

        return status[m - 1][n - 1];
    }

}
