package dfs;

/**
 * <pre>
 * https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof/。
 * </pre>
 *
 * @author Yishen 844147804@qq.com
 * @version 1.00.00
 */
public class JuZhenZhongDeLuJingLcof {

    private boolean visited = false;

    public boolean exist(char[][] board, String word) {
        visited = false;
        if (word == null || word.length() == 0) {
            return false;
        }
        char[] words = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (bfsSearch(board, words, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 1.如果当前下标对不上，则剪枝。
     * 2.board[i][j]访问之后，用空格标记已访问。
     */
    public boolean bfsSearch(char[][] board, char[] word, int i, int j, int k) {
        if (visited) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word[k]) {
            return false;
        }
        if (k == word.length - 1) {
            visited = true;
            return true;
        }

        board[i][j] = ' ';
        boolean res = bfsSearch(board, word, i + 1, j, k + 1) || bfsSearch(board, word, i - 1, j, k + 1)
                || bfsSearch(board, word, i, j + 1, k + 1) || bfsSearch(board, word, i, j - 1, k + 1);
        board[i][j] = word[k];
        return res;
    }
}
