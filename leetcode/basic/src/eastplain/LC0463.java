package eastplain;

/**
 * @author EastPlain
 * @create 2021-4-13 10:29
 */
public class LC0463 {
}


class IslandPerimeter {

    public int method(int[][] grid) {

        int ans = 0;
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == 1) {
                    ans += perimeter(grid, i, j);
                }
            }
        }
        return ans;
    }

    public int perimeter(int[][] grid, int r, int c) {

        if (!inArea(grid, r, c)) {
            return 1;
        }

        if (grid[r][c] == 0) {
            return 1;
        }

        if (grid[r][c] == 2) {
            return 0;
        }

        grid[r][c] = 2;

        return perimeter(grid, r - 1, c) + perimeter(grid, r, c - 1) + perimeter(grid, r + 1, c) + perimeter(grid, r, c + 1);
    }

    public boolean inArea(int[][] grid, int r, int c) {
        return r >= 0 && r < grid.length && c >= 0 && c < grid[0].length;
    }
}
