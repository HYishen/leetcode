package heap;

/**
 * https://leetcode.cn/problems/kth-largest-element-in-an-array/description/?envType=study-plan-v2&envId=top-100-liked
 * 215. 数组中的第K个最大元素
 * @date 2024-12-05 09:27:07
 */
public class KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        buildHeap(nums, n);
        for (int i = 1; i < k; i++) {
            swap(nums, 0, n - i);
            heapify(nums, n - i, 0);
        }
        return nums[0];
    }

    public void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public void buildHeap(int[] array, int n) {
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(array, n, i);
        }
    }

    public void heapify(int[] array, int n, int i) {
        while(true) {
            int maxPos = i;
            if ((i * 2 + 1) < n && array[i] < array[i * 2 + 1]) {
                maxPos = i * 2 + 1;
            }
            if ((i * 2 + 2) < n && array[maxPos] < array[i * 2 + 2]) {
                maxPos = i * 2 + 2;
            }
            if (maxPos == i) {
                break;
            }
            swap(array, i, maxPos);
            i = maxPos;
        }
    }
}
