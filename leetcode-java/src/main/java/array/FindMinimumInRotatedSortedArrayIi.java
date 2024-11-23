package array;

/**
 * <pre>
 * https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array-ii/。
 * </pre>
 *
 * @author Yishen 844147804@qq.com
 * @version 1.00.00
 */
public class FindMinimumInRotatedSortedArrayIi {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int pivot = low + (high - low) / 2;
            if (nums[pivot] < nums[high]) {
                // 如果nums[pivot] < nums[high]，则证明pivot在右侧数组上面
                high = pivot;
            } else if (nums[pivot] > nums[high]) {
                // 如果nums[pivot] > nums[high]，则证明pivot在左侧数组上面
                low = pivot + 1;
            } else {
                // 如果nums[pivot] = nums[high]，则nums[pivot] <= nums[high - 1]
                high -= 1;
            }
        }
        return nums[low];
    }
}
