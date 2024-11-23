package nowcoder.huawei;

import java.util.Scanner;

/**
 * <pre>
 * https://www.nowcoder.com/practice/22948c2cad484e0291350abad86136c3?tpId=37&tqId=21331&rp=1&ru=%2Fta%2Fhuawei&qru=%2Fta%2Fhuawei%2Fquestion-ranking&tab=answerKey。
 * 求最大公约数有两种方法 更相减损法和辗转相处法 最小公倍数在求出最大公约数后 两个数相乘除以最大公约数就是最小公倍数
 * 以下我们用的是更相减损法
 * 更相减损法是拿两个数中的较大值减去较小值，然后在减数、被减数、差之间选取两个较小值继续相减，直到减数和被减数相等，得出的数就是最大公约数。
 * 例：//更相减损术：
 * //8 10
 * //10 - 8=2
 * //8 - 2= 6
 * //6-2=4
 * //4-2=2
 * //2==2于是最大公约数就是2
 * </pre>
 *
 * @author Yishen 844147804@qq.com
 * @version 1.00.00
 */
public class HJ108 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n1 = in.nextInt();
        int n2 = in.nextInt();
        System.out.println(n1 * n2 / findNumber(n1, n2));
    }

    public static int findNumber(int n1, int n2) {
        if (n1 == n2) return n1;
        if (n1 > n2) {
            return findNumber(n2, n1 - n2);
        } else {
            return findNumber(n1, n2 - n1);
        }
    }
}
