package recursive;

import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 注意：给定 n 是一个正整数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/climbing-stairs
 * </pre>
 *
 * @author Yishen 844147804@qq.com
 * @version 1.00.00
 */
public class ClimbingStairs {

    private Map<Integer, Integer> solutionMap = new HashMap<>();

    public int climbStairs(int n) {
        if (solutionMap.containsKey(n)) {
            return solutionMap.get(n);
        }
        if (n < 1) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;
        int solution = climbStairs(n - 1) + climbStairs(n - 2);
        solutionMap.put(n, solution);
        return solution;
    }
}
