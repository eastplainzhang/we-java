package eastplain;

import java.util.Arrays;

/**
 * LC1605
 * 20201204
 * Time     40
 * Storage  71
 * 贪心算法
 * 解题区的方法
 * https://leetcode-cn.com/problems/find-valid-matrix-given-row-and-column-sums/solution/tan-xin-fa-fu-tu-jie-bao-zheng-neng-dong-by-durant/
 */

public class LC1605 {

    public static void main(String[] args) {
        RestoreMatrix rm = new RestoreMatrix();
        int[] r = new int[]{14, 9};
        int[] c = new int[]{6, 9 , 8};
        System.out.println(Arrays.deepToString(rm.method(r, c)));
    }
}


class RestoreMatrix {

    public int[][] method(int[] rowSum, int[] colSum) {
        int rowNum = rowSum.length;
        int colNum = colSum.length;
        int[][] ans = new int[rowNum][colNum];
        for (int i = 0; i < rowNum; ++i) {
            for (int j = 0; j < colNum; ++j) {
                ans[i][j] = Math.min(rowSum[i], colSum[j]);
                rowSum[i] -= ans[i][j];
                colSum[j] -= ans[i][j];
            }
        }
        return ans;
    }
}
