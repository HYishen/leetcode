package string;

/**
 * <pre>
 * Yishen 844147804@qq.com。
 * </pre>
 *
 * @author huangyishen yishen.huang@meicloud.com
 * @version 1.00.00
 */
public class TiHuanKongGeLcof {
    public String replaceSpace(String s) {
        int length = s.length();
        if (length == 0) return s;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (' ' == c) {
                sb.append("%20");
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
