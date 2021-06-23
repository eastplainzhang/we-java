package eastplain;

/**
 * LCOF04
 * 20201210
 * Time     100
 * Storage  65
 * 双指针，找到执行循环的边界条件
 * 当天循环体内是直接遍历的
 * 可以进一步优化，比如使用线性查找和二分查找
 */
public class LCOF04 {

    public static void main(String[] args) {
        FindNumberIn2dArray find = new FindNumberIn2dArray();
        int[][] mat = new int[][]{
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        System.out.println(find.method(mat, 21));
    }
}


class FindNumberIn2dArray {

    public boolean method(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0) { return false; }
        int n = matrix[0].length;
        if (n == 0) { return false; }

        int mp_min = 0;
        while (mp_min < m && matrix[mp_min][n - 1] < target) {
            mp_min += 1;
        }

        int mp_max = m - 1;
        while (mp_max >= 0 && matrix[mp_max][0] > target) {
            mp_max -= 1;
        }

        if (mp_min > mp_max) {
            return false;
        }

        int np_min = 0;
        while (np_min < n && matrix[m - 1][np_min] < target) {
            np_min += 1;
        }

        int np_max = n - 1;
        while (np_max >= 0 && matrix[0][np_max] > target) {
            np_max -= 1;
        }

        if (np_min > np_max) {
            return false;
        }

        for (int i = mp_min; i <= mp_max; ++i) {
            for (int j = np_min; j <= np_max; ++j) {
                if (matrix[i][j] == target) {
                    return true;
                }
            }
        }

        return false;
    }
}
