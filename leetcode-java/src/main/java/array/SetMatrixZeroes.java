package array;

import java.util.*;

/**
 * <pre>
 * https://leetcode-cn.com/problems/set-matrix-zeroes/。
 * </pre>
 *
 * @author Yishen 844147804@qq.com
 * @version 1.00.00
 */
public class SetMatrixZeroes {

    public void setZeroes(int[][] matrix) {
        Set<Map<String, Integer>> spots = new HashSet<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    Map<String, Integer> spot = new HashMap<>(2);
                    spot.put("row", i);
                    spot.put("col", j);
                    spots.add(spot);
                }
            }
        }

        Iterator<Map<String, Integer>> iterator = spots.iterator();
        while (iterator.hasNext()) {
            Map<String, Integer> next = iterator.next();
            Integer row = next.get("row");
            Integer col = next.get("col");

            for (int i = 0; i < matrix[row].length; i++) {
                matrix[row][i] = 0;
            }

            for (int i = 0; i < matrix.length; i++) {
                matrix[i][col] = 0;
            }
        }
    }

}
