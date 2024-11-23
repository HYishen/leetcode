package stack;

import java.util.Stack;

/**
 * <pre>
 * https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/。
 * </pre>
 *
 * @author Yishen 844147804@qq.com
 * @version 1.00.00
 */
public class YongLiangGeZhanShiXianDuiLieLcof {
    private Stack<Integer> headStack;
    private Stack<Integer> tailStack;

    public YongLiangGeZhanShiXianDuiLieLcof() {
        headStack = new Stack<>();
        tailStack = new Stack<>();
    }

    public void appendTail(int value) {
        headStack.push(value);
    }

    public int deleteHead() {
        while (!headStack.isEmpty()) {
            tailStack.push(headStack.pop());
        }
        int res = -1;
        if (!tailStack.isEmpty()) {
            res = tailStack.pop();
        }
        while (!tailStack.isEmpty()) {
            headStack.push(tailStack.pop());
        }
        return res;
    }
}

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */
/* 官方答案

class CQueue {
    Deque<Integer> stack1;
    Deque<Integer> stack2;

    public CQueue() {
        stack1 = new LinkedList<Integer>();
        stack2 = new LinkedList<Integer>();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        // 如果第二个栈为空
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        if (stack2.isEmpty()) {
            return -1;
        } else {
            int deleteItem = stack2.pop();
            return deleteItem;
        }
    }
}
*/
