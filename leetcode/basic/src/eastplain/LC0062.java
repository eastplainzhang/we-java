package eastplain;

/**
 * LC0062
 * 20201210
 * 一开始用递归做，超时
 * 然后尝试用动态规划创建数组的方法，通过
 * 看了解答区之后，发现更简单的组合数学的方法
 * https://leetcode-cn.com/problems/unique-paths/solution/bu-tong-lu-jing-by-leetcode-solution-hzjf/
 */
public class LC0062 {

    public static void main(String[] args) {
        UniquePath up = new UniquePath();
        int demo_m = 1;
        int demo_n = 5;
        System.out.println(up.method(demo_m, demo_n));
    }
}


class UniquePath {

    /**
     * 递归方法
     * 超时  41/62
     */
    public int method_recursion(int m, int n) {
        if (m - 1 == 0 || n - 1 == 0) {
            return 1;
        }
       return method_recursion(m - 1, n) + method_recursion(m, n - 1);
    }

    /**
     * 动态规划
     * 创建数组的方法
     * 用空间换时间
     * 自己想出来
     * Time     100
     * Storage  82
     * Time     O(m * n)
     * Storage  O(m * n)
     */
    public int method(int m, int n) {
        int[][] store = new int[m][n];
        for (int i = 0; i < m; ++i) {
            store[i][0] = 1;
        }
        for (int j = 0; j < n; ++j) {
            store[0][j] = 1;
        }
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                store[i][j] = store[i - 1][j] + store[i][j - 1];
            }
        }

        return store[m - 1][n - 1];
    }
}
