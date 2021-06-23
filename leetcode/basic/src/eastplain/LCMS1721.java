package eastplain;

import java.util.Arrays;

/**
 * LCMS1721
 * 20201210
 * 动态规划
 * 没想出来
 * 看的解答区的方法
 * https://leetcode-cn.com/problems/volume-of-histogram-lcci/solution/dong-tai-gui-hua-by-wushaoling-2/
 * Time     100
 * Storage  91
 */
public class LCMS1721 {

    public static void main(String[] args) {
        Trap t = new Trap();
        int[] height_demo = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(t.method(height_demo));
    }
}


class Trap {

    /**
     * 动态规划
     * 对于当前位置可以的水量，由其左右的最大值和其本身的值所决定
     * 先找到每个位置的最大左值和最大右值，构建两个数组lmax和rmax
     * 位置i的水量 = min(lmax[i], rmax[i]) - height[i]
     * https://leetcode-cn.com/problems/volume-of-histogram-lcci/solution/dong-tai-gui-hua-by-wushaoling-2/
     */
    public int method(int[] height) {
        int count = 0;
        int len = height.length;
        if (len <= 2) { return 0; }

        int[] lmax = new int[len];
        lmax[0] = 0;
        for (int i = 1; i < len; ++i) {
            lmax[i] = Math.max(lmax[i - 1], height[i - 1]);
        }
        System.out.println("lmax: " + Arrays.toString(lmax));

        int[] rmax = new int[len];
        rmax[len - 1] = 0;
        for (int i = len - 2; i >= 0; --i) {
            rmax[i] = Math.max(rmax[i + 1], height[i + 1]);
        }
        System.out.println("rmax: " + Arrays.toString(rmax));

        int[] ans = new int[len];
        for (int i = 0; i < len; ++i) {
            ans[i] = Math.min(lmax[i], rmax[i]) - height[i];
            if (ans[i] < 0) { ans[i] = 0; }
            count += ans[i];
        }
        System.out.println("ans: " + Arrays.toString(ans));

        return count;
    }
}
