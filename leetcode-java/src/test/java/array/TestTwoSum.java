package array;

import org.junit.Test;

import java.util.Arrays;

/**
 * <pre>
 * 。
 * </pre>
 *
 * @author Yishen 844147804@qq.com
 * @version 1.00.00
 */
public class TestTwoSum {
    @Test
    public void testTwoSum() {
        int[] nums = new int[]{2, 7, 11, 15, 9, 3, 8};
        int target = 12;
        int[] ints = new TwoSum().twoSum(nums, target);
        for (int i : ints) {
            System.out.println(i);
        }
    }

    @Test
    public void testTwoSum2() {
        int[] nums = new int[]{2, 7, 11, 15, 9, 3, 8};
        int target = 12;
        int[] ints = new TwoSum().twoSum2(nums, target);
        for (int i : ints) {
            System.out.println(i);
        }
    }

    @Test
    public void testTwoSum3() {
        int[] nums = new int[]{2, 7, 11, 15, 9, 3, 8};
        int target = 12;
        int[] ints = new TwoSum().twoSum3(nums, target);
        for (int i : ints) {
            System.out.println(i);
        }
    }
}
