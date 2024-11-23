package array;

import org.junit.Test;

/**
 * <pre>
 * 。
 * </pre>
 *
 * @author Yishen 844147804@qq.com
 * @version 1.00.00
 */
public class TestFirstMissingPositive {
    @Test
    public void testFirstMissingPositive() {
        int[] nums = new int[]{1, 3, 5, 7, 2, 4, 11, 13};
        int i = new FirstMissingPositive().firstMissingPositive(nums);
        System.out.println(i);
    }
}
