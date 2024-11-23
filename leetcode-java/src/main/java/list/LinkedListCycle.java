package list;

import java.util.HashSet;
import java.util.Set;

/**
 * <pre>
 * https://leetcode-cn.com/problems/linked-list-cycle/。
 * </pre>
 *
 * @author Yishen 844147804@qq.com
 * @version 1.00.00
 */
public class LinkedListCycle {

    public boolean hasCycle(ListNode head) {
        if (head == null) return false;

        Set<ListNode> visitSet = new HashSet<>();
        visitSet.add(head);
        ListNode node = head;
        while (node.next != null) {
            node = node.next;
            if (visitSet.contains(node)) return true;
            else visitSet.add(node);
        }
        return false;
    }

    public boolean hasCycle2(ListNode head) {
        if (head == null) return false;

        ListNode node1 = head;
        ListNode node2 = head;
        while (node1.next != null) {
            node1 = node1.next;
            if (node2.next != null && node2.next.next != null) {
                node2 = node2.next.next;
            } else {
                return false;
            }
            if (node1 == node2) {
                return true;
            }
        }
        return false;
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
