package stack;

import org.junit.Test;

/**
 * <pre>
 * 。
 * </pre>
 *
 * @author Yishen 844147804@qq.com
 * @version 1.00.00
 */
public class TestEvaluateReversePolishNotation {
    @Test
    public void testEvaluateReversePolishNotation() {
        String[] tokens = new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        int i = new EvaluateReversePolishNotation().evalRPN(tokens);
        System.out.println(i);
    }
}
