package queue;

import org.junit.Test;

/**
 * <pre>
 * 。
 * </pre>
 *
 * @author Yishen 844147804@qq.com
 * @version 1.00.00
 */
public class TestSlidingWindowMaximum {
    @Test
    public void testSlidingWindowMaximum() {
        int[] array = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] result = new SlidingWindowMaximum().maxSlidingWindow(array, k);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
