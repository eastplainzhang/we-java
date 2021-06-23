package eastplain;

/**
 * @author EastPlain
 * @create 2021-4-12 17:16
 */
public class LC0695 {
}


class MaxAreaOfIsland {

    public int method(int[][] grid) {
        int ans = 0;
        for (int r = 0; r < grid.length; ++r) {
            for (int c = 0; c < grid[0].length; ++c) {
                if (grid[r][c] == 1) {
                    int temp = area(grid, r, c);
                    ans = Math.max(ans, temp);
                }
            }
        }

        return ans;
    }


    int area(int[][] grid, int r, int c) {
        if (!inArea(grid, r, c)) {
            return 0;
        }

        if (grid[r][c] != 1) {
            return 0;
        }

        grid[r][c] = 2;

        return 1 + area(grid, r - 1, c) + area(grid, r, c - 1) + area(grid, r + 1, c) + area(grid, r, c + 1);
    }

    boolean inArea(int[][] grid, int r, int c) {
        return r >= 0 && r < grid.length && c >= 0 && c < grid[0].length;
    }
}

