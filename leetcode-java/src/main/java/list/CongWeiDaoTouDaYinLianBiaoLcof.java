package list;

/**
 * <pre>
 * https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/。
 * </pre>
 *
 * @author Yishen 844147804@qq.com
 * @version 1.00.00
 */
public class CongWeiDaoTouDaYinLianBiaoLcof {

    public int[] reversePrint(ListNode head) {
        if (head == null) {
            return new int[0];
        }
        int length = 1;
        ListNode ite = head;
        while (ite.next != null) {
            ite = ite.next;
            length++;
        }
        int[] arr = new int[length];
        int i = length - 1;

        ite = head;
        arr[i--] = ite.val;
        while (ite.next != null) {
            ite = ite.next;
            arr[i--] = ite.val;
        }
        return arr;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
