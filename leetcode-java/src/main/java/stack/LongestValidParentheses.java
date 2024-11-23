package stack;

import java.util.*;

/**
 * <pre>
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 * https://leetcode-cn.com/problems/longest-valid-parentheses/
 * </pre>
 *
 * @author Yishen 844147804@qq.com
 * @version 1.00.00
 */
public class LongestValidParentheses {

    public int longestValidParentheses(String s) {
        if (s == null || "".equals(s)) return 0;
        String p = "p";
        String f = "f";

        Stack<Map<String, Object>> stack = new Stack<>();

        List<Map<String, Object>> idxList = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            Map<String, Object> pMap = new HashMap<>();
            pMap.put(p, s.charAt(i));
            pMap.put(f, false);
            idxList.add(pMap);
        }
        for (Map<String, Object> pMap : idxList) {
            if (stack.isEmpty()) {
                stack.push(pMap);
            } else {
                Map<String, Object> pcMap = stack.pop();
                if (Objects.equals('(', (char) pcMap.get(p)) && Objects.equals(')', (char) pMap.get(p))) {
                    pMap.put(f, true);
                    pcMap.put(f, true);
                } else {
                    stack.push(pcMap);
                    stack.push(pMap);
                }
            }
        }
        int maxCount = 0;
        int count = 0;
        for (Map<String, Object> map : idxList) {
            Boolean find = (Boolean) map.get(f);
            if (find) {
                count++;
            } else {
                maxCount = Math.max(maxCount, count);
                count = 0;
            }
        }
        maxCount = Math.max(maxCount, count);
        return maxCount;
    }

    /**
     * 动态规划解决方案。
     *
     * @param s
     * @return
     */
    public int longestValidParentheses2(String s) {
        if (s == null || "".equals(s)) return 0;
        int maxCount = 0;

        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (')' == c) {
                if ('(' == s.charAt(i - 1)) {
                    if (i - 2 >= 0) {
                        dp[i] = dp[i - 2] + 2;
                    } else {
                        dp[i] = 2;
                    }
                } else if (')' == s.charAt(i - 1)) {
                    if (i - dp[i - 1] - 1 >= 0 && '(' == s.charAt(i - dp[i - 1] - 1)) {
                        if (i - dp[i - 1] - 2 >= 0) {
                            dp[i] = dp[i - 1] + dp[i - dp[i - 1] - 2] + 2;
                        } else {
                            dp[i] = dp[i - 1] + 2;
                        }
                    }
                }
                maxCount = Math.max(dp[i], maxCount);
            }
        }
        return maxCount;
    }

}
