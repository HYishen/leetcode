package queue;

/**
 * <pre>
 * 设计实现双端队列。
 * 你的实现需要支持以下操作：
 *
 *     MyCircularDeque(k)：构造函数,双端队列的大小为k。
 *     insertFront()：将一个元素添加到双端队列头部。 如果操作成功返回 true。
 *     insertLast()：将一个元素添加到双端队列尾部。如果操作成功返回 true。
 *     deleteFront()：从双端队列头部删除一个元素。 如果操作成功返回 true。
 *     deleteLast()：从双端队列尾部删除一个元素。如果操作成功返回 true。
 *     getFront()：从双端队列头部获得一个元素。如果双端队列为空，返回 -1。
 *     getRear()：获得双端队列的最后一个元素。 如果双端队列为空，返回 -1。
 *     isEmpty()：检查双端队列是否为空。
 *     isFull()：检查双端队列是否满了。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/design-circular-deque
 * </pre>
 *
 * @author Yishen 844147804@qq.com
 * @version 1.00.00
 */
public class MyCircularDeque {

    int[] array;
    int head;
    int rear;
    int size;

    /**
     * Initialize your data structure here. Set the size of the deque to be k.
     */
    public MyCircularDeque(int k) {
        this.array = new int[k];
    }

    /**
     * Adds an item at the front of Deque. Return true if the operation is successful.
     */
    public boolean insertFront(int value) {
        if (size == array.length) return false;
        if (head == rear && size == 0) {
            array[head] = value;
            size++;
            return true;
        }
        int afterIndex = (head + 1) % array.length;
        array[afterIndex] = value;
        head = afterIndex;
        size++;
        return true;
    }

    /**
     * Adds an item at the rear of Deque. Return true if the operation is successful.
     */
    public boolean insertLast(int value) {
        if (size == array.length) return false;
        if (head == rear && size == 0) {
            array[rear] = value;
            size++;
            return true;
        }
        int afterIndex = (rear - 1) < 0 ? array.length - 1 : rear - 1;
        array[afterIndex] = value;
        rear = afterIndex;
        size++;
        return true;
    }

    /**
     * Deletes an item from the front of Deque. Return true if the operation is successful.
     */
    public boolean deleteFront() {
        if (size == 0) return false;
        if (size == 1) {
            size = 0;
            return true;
        }
        int afterIndex = (head - 1) < 0 ? array.length - 1 : head - 1;
        head = afterIndex;
        size--;
        return true;
    }

    /**
     * Deletes an item from the rear of Deque. Return true if the operation is successful.
     */
    public boolean deleteLast() {
        if (size == 0) return false;
        if (size == 1) {
            size = 0;
            return true;
        }
        int afterIndex = (rear + 1) % array.length;
        rear = afterIndex;
        size--;
        return true;
    }

    /**
     * Get the front item from the deque.
     */
    public int getFront() {
        if (size == 0) return -1;
        return array[head];
    }

    /**
     * Get the last item from the deque.
     */
    public int getRear() {
        if (size == 0) return -1;
        return array[rear];
    }

    /**
     * Checks whether the circular deque is empty or not.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Checks whether the circular deque is full or not.
     */
    public boolean isFull() {
        return size == array.length;
    }
}
