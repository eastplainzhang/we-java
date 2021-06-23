package eastplain;

/**
 * @author EastPlain
 * @create 2021-4-15 13:41
 */

public class LCOF12 {
}


class Exist {

    public boolean exist(char[][] board, String word) {

        char[] word_arr = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, word_arr, i, j, 0)) {
                    return true;
                }
            }
        }

        return false;
    }


    boolean dfs(char[][] board, char[] word_arr, int i, int j, int p) {

        int m = board.length;
        int n = board[0].length;

        if (i < 0 || i >= m || j < 0 || j >= n || board[i][j] != word_arr[p]) {
            return false;
        }

        if (p == word_arr.length - 1) {
            return true;
        }

        board[i][j] = '\0';

        boolean res = dfs(board, word_arr, i - 1, j, p + 1) ||
                      dfs(board, word_arr, i, j - 1, p + 1) ||
                      dfs(board, word_arr, i + 1, j, p + 1) ||
                      dfs(board, word_arr, i, j + 1, p + 1);

        board[i][j] = word_arr[p];

        return res;
    }
}



