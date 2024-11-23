package queue;

import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * <pre>
 * 。
 * </pre>
 *
 * @author Yishen 844147804@qq.com
 * @version 1.00.00
 */
public class TestHuaDongChuangKouDeZuiDaZhiLcof {

    @Test
    public void testHuaDongChuangKouDeZuiDaZhiLcof() {
        int[] arr = new int[]{9,10,9,-7,-4,-8,2,-6};
        int k = 5;

        int[] res = new HuaDongChuangKouDeZuiDaZhiLcof().maxSlidingWindow2(arr, k);

        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + ", ");
        }
    }

}
