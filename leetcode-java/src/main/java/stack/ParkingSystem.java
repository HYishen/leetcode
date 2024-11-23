package stack;

import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 * https://leetcode-cn.com/problems/design-parking-system/。
 * </pre>
 *
 * @author Yishen 844147804@qq.com
 * @version 1.00.00
 */
public class ParkingSystem {

    private Map<Integer, Stack> parkingSpot;

    public ParkingSystem(int big, int medium, int small) {
        parkingSpot = new HashMap<>();
        parkingSpot.put(1, new Stack(big));
        parkingSpot.put(2, new Stack(medium));
        parkingSpot.put(3, new Stack(small));
    }

    public boolean addCar(int carType) {
        Stack spot = parkingSpot.get(carType);
        if (spot.isFull()) {
            return false;
        }
        spot.push(1);
        return true;
    }

    static class Stack {
        private int[] datas;
        private int topIdx;

        public Stack(int capacity) {
            datas = new int[capacity];
            topIdx = 0;
        }

        public void push(int val) {
            if (topIdx >= datas.length) {
                throw new RuntimeException("The stack is full.");
            }
            datas[topIdx++] = val;
        }

        public int pop() {
            if (topIdx <= 0) {
                throw new RuntimeException("The stack is empty.");
            }
            int res = datas[topIdx - 1];
            topIdx--;
            return res;
        }

        public int peek() {
            if (topIdx <= 0) {
                throw new RuntimeException("The stack is empty.");
            }
            int res = datas[topIdx - 1];
            return res;
        }

        public boolean isEmpty() {
            return topIdx <= 0;
        }

        public boolean isFull() {
            return topIdx >= datas.length;
        }
    }
}
