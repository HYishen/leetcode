package list;

/**
 * <pre>
 * https://leetcode-cn.com/problems/merge-k-sorted-lists/。
 * </pre>
 *
 * @author Yishen 844147804@qq.com
 * @version 1.00.00
 */
public class MergeKSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null) return null;
        ListNode result = null;
        ListNode resultTail = null;

        while (true) {
            int index = -1;
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < lists.length; i++) {
                ListNode node = lists[i];
                if (node == null) continue;
                if (node.val < min) {
                    index = i;
                    min = node.val;
                }
            }
            if (index == -1) break;
            if (result == null) {
                result = lists[index];
                resultTail = lists[index];
            } else {
                resultTail.next = lists[index];
                resultTail = resultTail.next;
            }
            lists[index] = lists[index].next;
        }
        return result;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
