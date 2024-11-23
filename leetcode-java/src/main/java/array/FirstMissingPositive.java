package array;

/**
 * <pre>
 * 给定一个未排序的整数数组，找出其中没有出现的最小的正整数。
 * 你的算法的时间复杂度应为O(n)，并且只能使用常数级别的空间。
 * </pre>
 *
 * @author Yishen 844147804@qq.com
 * @version 1.00.00
 */
public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        int firstMissingPositive = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                firstMissingPositive++;
                break;
            }
        }

        if (firstMissingPositive == 0) return 1;
        if (n == 1) return 2;

        // 首次缺失的正数一定小于或等于 n + 1，把小于等于0和大于n的都变成1
        for (int i = 0; i < n; i++) {
            if ((nums[i] <= 0) || (nums[i] > n)) {
                nums[i] = 1;
            }
        }

        for (int i = 0; i < n; i++) {
            int index = Math.abs(nums[i]);
            if (index == n) {
                nums[0] = -Math.abs(nums[0]);
            } else {
                nums[index] = -Math.abs(nums[index]);
            }
        }

        for (int i = 1; i < n; i++) {
            if (nums[i] > 0) return i;
        }
        if (nums[0] > 0) return n;
        return n + 1;
    }
}
