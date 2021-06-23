package eastplain;

import java.util.Arrays;

/**
 * LCOF29
 * 20210125
 * Time     97
 * Storage  8
 */
public class LCOF29 {

    public static void main(String[] args) {
        SpiralOrder s = new SpiralOrder();
        int[][] demo = new int[][]{{5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        System.out.println(Arrays.toString(s.method(demo)));
    }
}


class SpiralOrder {

    public int[] method(int[][] matrix) {

        if (matrix == null || matrix.length == 0) {
            return new int[0];
        }

        int left = 0;
        int top = 0;
        int right = matrix[0].length - 1;
        int bottom = matrix.length - 1;
        int[] ans = new int[matrix.length * matrix[0].length];
        int k = 0;

        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++) {
                ans[k++] = matrix[top][i];
            }
            top ++;
            for (int i = top; i <= bottom; i++) {
                ans[k++] = matrix[i][right];
            }
            right --;
            for (int i = right; i >= left && top <= bottom; i--) {
                ans[k++] = matrix[bottom][i];
            }
            bottom --;
            for (int i = bottom; i >= top && left <= right; i--) {
                ans[k++] = matrix[i][left];
            }
            left ++;
        }

        return ans;

    }
}
