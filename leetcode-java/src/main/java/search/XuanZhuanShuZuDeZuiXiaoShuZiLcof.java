package search;

/**
 * <pre>
 * https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/。
 * </pre>
 *
 * @author Yishen 844147804@qq.com
 * @version 1.00.00
 */
public class XuanZhuanShuZuDeZuiXiaoShuZiLcof {

    public int minArray(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return -1;
        }
        if (numbers.length == 1) {
            return numbers[0];
        }
        int low = 0;
        int high = numbers.length - 1;
        while (low < high) {
            int pivot = low + (high - low) / 2;
            if (numbers[pivot] < numbers[high]) {
                // 如果numbers[pivot] < numbers[high]，证明pivot在右侧有序数组上面
                high = pivot;
            } else if (numbers[pivot] > numbers[high]) {
                // 如果numbers[pivot] > numbers[high]，证明pivot在作出有序数组上面
                low = pivot + 1;
            } else {
                // 如果numbers[pivot] == numbers[high]，则无法判断pivot在那一部分的数组上面，但是可以保证numbers[pivot] <= numbers[high - 1]
                high -= 1;
            }
        }
        return numbers[low];
    }
}
