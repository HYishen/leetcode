package nowcoder.huawei;

import java.util.*;

/**
 * <pre>
 * https://www.nowcoder.com/practice/de044e89123f4a7482bd2b214a685201?tpId=37&tqId=21231&rp=1&ru=%2Fta%2Fhuawei&qru=%2Fta%2Fhuawei%2Fquestion-ranking&tab=answerKey。
 * 合并表记录。
 * </pre>
 *
 * @author Yishen 844147804@qq.com
 * @version 1.00.00
 */
public class HJ8 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String numStr = in.nextLine();
        int num = Integer.parseInt(numStr);
        Map<Integer, Integer> map = new HashMap<>(num);
        for(int i = 0; i < num; i++) {
            String nStr = in.nextLine();
            String[] split = nStr.split("\\s");
            int n = Integer.parseInt(split[0]);
            int val = Integer.parseInt(split[1]);
            map.put(n, map.get(n) == null ? val : map.get(n) + val);
        }
        Iterator<Map.Entry<Integer, Integer>> itr = map.entrySet().iterator();
        while (itr.hasNext()) {
            Map.Entry<Integer, Integer> ent = itr.next();
            System.out.println(ent.getKey() + " " + ent.getValue());
        }
    }
}
