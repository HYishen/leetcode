package heap;

import org.junit.Test;

public class TestKthLargestElementInAnArray {

    @Test
    public void test_buildHeap() {
        int[] nums = new int[]{3,2,1,5,6,4};
        KthLargestElementInAnArray solution = new KthLargestElementInAnArray();
        solution.buildHeap(nums, nums.length);

        boolean check = true;
        for (int i = 0; i < (nums.length + 1) / 2; i++) {
            if (i * 2 + 1 < nums.length - 1 && nums[i] < nums[i * 2 + 1]) {
                check = false;
            }
            if (i * 2 + 2 < nums.length - 1 && nums[i] < nums[i * 2 + 2]) {
                check = false;
            }
        }
        System.out.println(check);
    }

    @Test
    public void test_findKthLargest() {
        int[] nums = new int[]{3,2,1,5,6,4};
        KthLargestElementInAnArray solution = new KthLargestElementInAnArray();
        solution.findKthLargest(nums, 2);
        System.out.println(nums[0]);
    }

    @Test
    public void test_border() {
        System.out.println(1/2);
    }
}
