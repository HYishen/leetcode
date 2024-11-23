package stack;

/**
 * <pre>
 * https://leetcode-cn.com/problems/min-stack/。
 *
 * 官方辅答案: 辅助栈
 * https://leetcode-cn.com/problems/min-stack/solution/zui-xiao-zhan-by-leetcode-solution/
 * </pre>
 *
 * @author Yishen 844147804@qq.com
 * @version 1.00.00
 */
public class MinStack {

    private int[] datas;

    private int topIdx;

    private int minVal;

    /** initialize your data structure here. */
    public MinStack() {
        datas = new int[10000];
        topIdx = 0;
        minVal = Integer.MAX_VALUE;
    }

    public void push(int val) {
        if (topIdx >= datas.length) {
            return;
        }
        datas[topIdx++] = val;

        if (val <= minVal) {
            minVal = val;
        }
    }

    public void pop() {
        topIdx--;
        if (topIdx <= 0) {
            minVal = Integer.MAX_VALUE;
        } else {
            this.findMin();
        }
    }

    public int top() {
        if (topIdx <= 0) {
            throw new RuntimeException("the stack is empty!");
        }
        return datas[topIdx - 1];
    }

    public int getMin() {
        return minVal;
    }

    private void findMin() {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < topIdx; i++) {
            if (datas[i] <= min) {
                min = datas[i];
            }
        }
        minVal = min;
    }
}
