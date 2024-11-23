package string;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
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
public class TestReverseString {
    @Test
    public void testReverseString() {
        char[] s = new char[]{'h', 'a', 'n', 'n', 'a', 'H'};
        new ReverseString().reverseString(s);
        List<Character> list = new ArrayList<>(s.length);
        for (int i = 0; i < s.length; i++) {
            list.add(s[i]);
        }
        System.out.println(list);
    }
}
