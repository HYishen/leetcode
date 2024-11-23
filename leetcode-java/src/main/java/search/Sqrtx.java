package search;

/**
 * <pre>
 * 实现 int sqrt(int x) 函数。
 *
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 *
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sqrtx
 * </pre>
 *
 * @author Yishen 844147804@qq.com
 * @version 1.00.00
 */
public class Sqrtx {
    /**
     * 从几何角度来看，整数平方根就是小于 x 的最大正方形的边长。
     * 当x>=2时，它的整数平方根一定小于x/2，且大于1，即2<a<x/2
     */
    public int mySqrt(int x) {
        if (x < 2) return x;
        int left = 2;
        int right = x >> 1;
        while (left <= right) {
            int pivot = left + ((right - left) >> 1);
            long i = (long) pivot * pivot;
            if (i > x) {
                right = pivot - 1;
            } else if (i < x) {
                left = pivot + 1;
            } else {
                return pivot;
            }
        }
        return right;
    }
}
