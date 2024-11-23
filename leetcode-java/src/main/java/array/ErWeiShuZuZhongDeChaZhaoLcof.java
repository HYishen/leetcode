package array;

/**
 * <pre>
 * https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/。
 * </pre>
 *
 * @author Yishen 844147804@qq.com
 * @version 1.00.00
 */
public class ErWeiShuZuZhongDeChaZhaoLcof {
    /** 标准答案 */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int rows = matrix.length, columns = matrix[0].length;
        int row = 0, column = columns - 1;
        while (row < rows && column >= 0) {
            int num = matrix[row][column];
            if (num == target) {
                return true;
            } else if (num > target) {
                column--;
            } else {
                row++;
            }
        }
        return false;
    }

    /** 暴力解法 */
    public boolean findNumberIn2DArraySelf(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int row = matrix.length;
        int column = matrix[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (target == matrix[i][j]) {
                    return true;
                } else if (target < matrix[i][j]) {
                    break;
                }
            }
        }
        return false;
    }

    /**
     * 此递归方案超时
     */
    private boolean findNumber(int[][] matrix, int target, int n, int m, int i, int j) {
        if (i >= n || j >= m) {
            return false;
        }

        if (matrix[i][j] == target) {
            return true;
        }

        if (matrix[i][j] > target) {
            return false;
        }

        return findNumber(matrix, target, n, m, i + 1, j) || findNumber(matrix, target, n, m, i, j + 1);
    }
}
