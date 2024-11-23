package list;

/**
 * <pre>
 * https://leetcode-cn.com/problems/reverse-linked-list-ii/。
 * </pre>
 *
 * @author Yishen 844147804@qq.com
 * @version 1.00.00
 */
public class ReverseLinkedListIi {

    public static ListNode reverseBetween1(ListNode head, int left, int right) {
        if (head == null) {
            return null;
        }
        if (left == right) {
            return head;
        }

        ListNode currentNode = head;
        ListNode mergeHead = null;
        ListNode reverseHead = null;
        ListNode reverseTail = null;

        int i = 1;
        while (currentNode != null && i <= right) {
            // 如果是left是链表头，则mergeHead特殊处理
            if (left == 1) {
                mergeHead = new ListNode();
            }

            if (i == left - 1) {
                mergeHead = currentNode;
            }

            if (i == left) {
                reverseTail = currentNode;
                reverseHead = currentNode;
            }

            if (i > left && i < right) {
                ListNode next = currentNode.next;
                currentNode.next = reverseHead;
                reverseHead = currentNode;
                currentNode = next;
                i++;
                continue;
            }

            // right 不是边界值的情况
            if (i == right && currentNode.next != null) {
                ListNode mergeTail = currentNode.next;

                currentNode.next = reverseHead;
                reverseHead = currentNode;

                mergeHead.next = reverseHead;
                reverseTail.next = mergeTail;
            } else if (i == right) {
                currentNode.next = reverseHead;
                reverseHead = currentNode;
                mergeHead.next = reverseHead;
                reverseTail.next = null;
            }

            currentNode = currentNode.next;
            i++;
        }

        // 如果是left是链表头，则mergeHead特殊处理
        if (left == 1) {
            return mergeHead.next;
        }
        return head;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
