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
public class TestReverseWordsInAString {

    @Test
    public void testReverseWordsInAString() {
        String s = "a good   example";
        System.out.println(new ReverseWordsInAString().reverseWords(s));
    }

}
