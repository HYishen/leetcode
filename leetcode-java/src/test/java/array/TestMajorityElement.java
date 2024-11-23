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
public class TestMajorityElement {
    @Test
    public void testMajorityElement() {
        int[] nums = new int[]{2, 2, 1, 1, 1, 2, 2};
        int i = new MajorityElement().majorityElement(nums);
        System.out.println(i);
    }
}
