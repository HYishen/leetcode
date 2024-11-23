package array;

/**
 * <pre>
 * https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/。
 * </pre>
 *
 * @author Yishen 844147804@qq.com
 * @version 1.00.00
 */
public class ShuZuZhongZhongFuDeShuZiLcof {
    public int findRepeatNumber(int[] nums) {
        int[] arr = new int[nums.length];
        int res = -1;

        for (int num : nums) {
            arr[num] += 1;
        }

        for (int i = 0; i < nums.length; i++) {
            if (arr[i] > 1) {
                res = i;
                break;
            }
        }
        return res;
    }
}
