package list;

import org.junit.Assert;
import org.junit.Test;

/**
 * <pre>
 * 。
 * </pre>
 *
 * @author Yishen 844147804@qq.com
 * @version 1.00.00
 */
public class TestReverseLinkedListIi {

    @Test
    public void testReverseLinkedListIi() {
        int[] vals = new int[]{3, 5};
        int[] expect = new int[]{5, 3};
        ReverseLinkedListIi.ListNode head = new ReverseLinkedListIi.ListNode(vals[0]);
        ReverseLinkedListIi.ListNode current = head;
        for (int i = 1; i < vals.length; i++) {
            ReverseLinkedListIi.ListNode node = new ReverseLinkedListIi.ListNode(vals[i]);
            current.next = node;
            current = node;
        }

        head = ReverseLinkedListIi.reverseBetween1(head, 1, 2);
        int[] res = new int[vals.length];
        ReverseLinkedListIi.ListNode ite = head;
        int idx = 0;
        while (ite != null) {
            res[idx] = ite.val;
            ite = ite.next;
            idx++;
        }

        boolean flag = true;
        for (int i = 0; i < res.length && flag; i++) {
            flag = expect[i] == res[i];
        }

        Assert.assertEquals(true, flag);
    }

}
