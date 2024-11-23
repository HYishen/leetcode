package stack;

import org.junit.Test;

import java.util.Objects;

/**
 * <pre>
 * 。
 * </pre>
 *
 * @author Yishen 844147804@qq.com
 * @version 1.00.00
 */
public class TestLongestValidParentheses {

    @Test
    public void testLongestValidParentheses() {
        String s = ")()())";
        int i = new LongestValidParentheses().longestValidParentheses(s);
        System.out.println(i);
    }

    @Test
    public void testLongestValidParentheses2() {
        String s = "())";
        int i = new LongestValidParentheses().longestValidParentheses2(s);
        System.out.println(i);
    }
}
