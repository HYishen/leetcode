package string;

import org.junit.Test;

/**
 * <pre>
 * 。
 * </pre>
 *
 * @author Yishen 844147804@qq.com
 * @version 1.00.00
 */
public class TestStringToIntegerAtoi {
    @Test
    public void testStringToIntegerAtoi() {
        String str = "  0000000000012345678";
        System.out.println(new StringToIntegerAtoi().myAtoi(str));
    }
}
