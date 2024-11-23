package recursive;

/**
 * <pre>
 * https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof/。
 * </pre>
 *
 * @author Yishen 844147804@qq.com
 * @version 1.00.00
 */
public class QingWaTiaoTaiJieWenTiLcof {
    public int numWays(int n) {
        if (n <= 0) {
            return 1;
        }
        int res = 1;
        int pre = 1;
        int prepre = 0;
        for (int i = 0; i < n; i++) {
            res = (pre + prepre) % 1000000007;
            prepre = pre;
            pre = res;
        }
        return res;
    }
}
