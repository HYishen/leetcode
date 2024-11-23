package nowcoder.huawei;

import java.util.Scanner;

/**
 * <pre>
 * https://www.nowcoder.com/practice/1221ec77125d4370833fd3ad5ba72395?tpId=37&tqId=21260&rp=1&ru=%2Fta%2Fhuawei&qru=%2Fta%2Fhuawei%2Fquestion-ranking&tab=answerKey
 * 统计每个月兔子的总数。
 * </pre>
 *
 * @author Yishen 844147804@qq.com
 * @version 1.00.00
 */
public class HJ37 {
    /** 兔子总数=前两个月兔子总数之和 */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int r = 1;
            int r1 = 0;
            int r2 = 0;
            for (int i = 2; i <= n; i++) {
                r1 = r2;
                r2 = r;
                r = r1 + r2;
            }
            System.out.println(r);
        }
    }
}
