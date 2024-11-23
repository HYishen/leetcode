package array;

import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * </pre>
 *
 * @author Yishen 844147804@qq.com
 * @version 1.00.00
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, int[]> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            int[] indexs = new int[2];
            indexs[0] = i;
            // a + b = target; b = target -a
            map.put(target - nums[i], indexs);
        }

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int[] indexs = map.get(nums[i]);
                if (indexs[0] != i) {
                    indexs[1] = i;
                    return indexs;
                }
            }
        }
        return null;
    }

    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            // a + b = target; b = target -a
            map.put(target - nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                Integer index = map.get(nums[i]);
                if (index != i) {
                    return new int[]{index, i};
                }
            }
        }
        return null;
    }

    public int[] twoSum3(int[] nums, int target) {
        Map<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int[] result = map.get(nums[i]);
                result[1] = i;
                return result;
            }
            int[] indexs = new int[2];
            indexs[0] = i;
            // a + b = target; b = target -a
            map.put(target - nums[i], indexs);
        }
        return null;
    }

}
