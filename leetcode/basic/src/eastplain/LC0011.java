package eastplain;

/**
 * 20201128
 * LC0011
 *
 * method1
 * My method
 * Time     17
 * Storage  20
 *
 * method2
 * leetcode method
 * Time     93
 * Storage  36
 */

public class LC0011 {

    public static void main(String[] args) {

        MaxArea m1 = new MaxArea();
        int[] demo_height = new int[]{2, 3, 4, 5, 18, 17, 6};
        System.out.println(m1.method2(demo_height));
    }
}


class MaxArea {

    public int method1(int[] height) {

        int length = height.length;
        int lp = 0;
        int rp = length - 1;
        int ans = (rp - lp) * Math.min(height[lp], height[rp]);
        while (lp < rp) {
            int now = (rp - lp) * Math.min(height[lp], height[rp]);
            int move_l = (rp - (lp + 1)) * Math.min(height[lp + 1], height[rp]);
            int move_r = ((rp - 1) - lp) * Math.min(height[lp], height[rp - 1]);
            if (move_l > now && move_r > now) {
                if (move_l >= move_r) { lp += 1; }
                else {rp -= 1; }
            }
            else if (move_l > now) { lp += 1; }
            else if (move_r > now) { rp -= 1; }
            else {
                for (int i = lp; i < rp; ++i) {
                    for (int j = i + 1; j < rp + 1; ++j) {
                        if ((j - i) * Math.min(height[i], height[j]) > now) {
                            now = (j - i) * Math.min(height[i], height[j]);
                        }
                    }
                }
                ans = now;
                break;
            }
        }
        return ans;

    }

    public int method2(int[] height) {

        int length = height.length;
        // initialize
        int lp = 0;
        int rp = length - 1;
        int max = (rp - lp) * Math.min(height[lp], height[rp]);

        while (lp < rp) {
            if (height[lp] <= height[rp]) {
                lp += 1;
                int temp = (rp - lp) * Math.min(height[lp], height[rp]);
                if (temp > max) { max = temp; }
            }
            else {
                rp -= 1;
                int temp = (rp - lp) * Math.min(height[lp], height[rp]);
                if (temp > max) { max = temp; }
            }
        }

        return max;
    }
}
