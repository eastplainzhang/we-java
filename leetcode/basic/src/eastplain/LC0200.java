package eastplain;

/**
 * @author EastPlain
 * @create 2021-4-13 10:05
 */
public class LC0200 {

}


class NumIslands {

    public int method(char[][] grid) {

        int count = 0;
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == '1') {
                    area(grid, i, j);
                    count += 1;
                }
            }
        }
        return count;
    }

    public void area(char[][] grid, int r, int c) {

        if (!inArea(grid, r, c)) {
            return;
        }

        if (grid[r][c] != '1') {
            return;
        }

        grid[r][c] = '2';

        area(grid, r - 1, c);
        area(grid, r, c - 1);
        area(grid, r + 1, c);
        area(grid, r, c + 1);
    }

    public boolean inArea(char[][] grid, int r, int c) {
        return r >= 0 && r < grid.length && c >= 0 && c < grid[0].length;
    }
}
