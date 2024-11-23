package recursive;

/**
 * <pre>
 * https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof/。
 * </pre>
 *
 * @author Yishen 844147804@qq.com
 * @version 1.00.00
 */
public class FeiBoNaQiShuLieLcof {
    public int fib2(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        int fn = 0;
        int pre = 1;
        int prepre = 0;

        for (int i = 2; i <= n; i++) {
            fn = (pre + prepre) % 1000000007;
            prepre = pre;
            pre = fn;
        }
        return fn;
    }

    public int fib(int n) {
        return this.doFib(n);
    }

    private int doFib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return (doFib(n - 1) + doFib(n - 2)) % 1000000007;
    }
}
