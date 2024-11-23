package array;

import java.util.*;

/**
 * <pre>
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * </pre>
 *
 * @author Yishen 844147804@qq.com
 * @version 1.00.00
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Set<String> stringSet = new HashSet<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) {
                break;
            }
            int sum = nums[i];
            boolean secondFlag = true;
            for (int j = i + 1; secondFlag && j < nums.length - 1; j++) {
                sum += nums[j];
                if (sum >= 0 && nums[j + 1] > 0) {
                    secondFlag = false;
                    sum -= nums[j];
                    continue;
                }
                boolean thirdFlag = true;
                for (int k = j + 1; thirdFlag && k < nums.length; k++) {
                    sum += nums[k];
                    if (sum == 0) {
                        stringSet.add(nums[i] + "," + nums[j] + "," + nums[k]);
                        thirdFlag = false;
                    } else if (sum < 0) {
                        sum -= nums[k];
                        continue;
                    } else {
                        thirdFlag = false;
                    }
                    sum -= nums[k];
                }
                sum -= nums[j];
            }
        }
        for (String s : stringSet) {
            String[] split = s.split(",");
            result.add(Arrays.asList(new Integer[]{Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2])}));
        }
        return result;
    }

    public List<List<Integer>> threeSum2(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int i = 0; i < nums.length; i++) {
            // 当nums[i] > 0无需再进行判断
            if (nums[i] > 0) break;
            // 跳过重复的解
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    List<Integer> r = new ArrayList<>(3);
                    r.add(nums[i]);
                    r.add(nums[left]);
                    r.add(nums[right]);
                    result.add(r);
                    // 跳过重复的值
                    while (++left < right && nums[left] == nums[left - 1]) ;
                    while (left < --right && nums[right] == nums[right + 1]) ;
                } else if (sum < 0) {
                    // 跳过重复的值
                    while (++left < right && nums[left] == nums[left - 1]) ;
                } else {
                    // 跳过重复的值
                    while (left < --right && nums[right] == nums[right + 1]) ;
                }
            }
        }
        return result;
    }
}
