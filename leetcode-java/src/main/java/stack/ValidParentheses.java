package stack;

import java.util.*;

/**
 * <pre>
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 *     左括号必须用相同类型的右括号闭合。
 *     左括号必须以正确的顺序闭合。
 *
 * 注意空字符串可被认为是有效字符串。
 * </pre>
 *
 * @author Yishen 844147804@qq.com
 * @version 1.00.00
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        if (s == null) return false;

        Set<Character> parentheses = new HashSet<>();
        parentheses.add('(');
        parentheses.add(')');
        parentheses.add('{');
        parentheses.add('}');
        parentheses.add('[');
        parentheses.add(']');

        Map<Character, Character> parenthesesMap = new HashMap<>();
        parenthesesMap.put(')', '(');
        parenthesesMap.put('}', '{');
        parenthesesMap.put(']', '[');

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (parentheses.contains(c)) {
                if (stack.isEmpty()) {
                    stack.push(c);
                } else {
                    Character p = stack.pop();
                    if (!Objects.equals(parenthesesMap.get(c), p)) {
                        stack.push(p);
                        stack.push(c);
                    }
                }
            }
        }

        if (stack.isEmpty()) return true;
        return false;
    }
}
