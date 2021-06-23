package eastplain;

import java.util.Arrays;

/**
 * @author EastPlain
 * @create 2021-4-16 10:58
 */
public class LC0055 {

    public static void main(String[] args) {
        int[] demo = new int[]{3, 2, 1, 0, 4};
        System.out.println(new CanJump().method_greedy(demo));
    }
}


class CanJump {

    /**
     * 动态规划
     */
    public boolean method_dp(int[] nums) {

        int length = nums.length;
        int[] ans = new int[length];

        for (int i = 0; i < length; ++i) {
            ans[i] = (int) (Math.pow(10, 4) * 3);
        }

        ans[length - 1] = 0;

        for (int i = length - 2; i >= 0; --i) {
            int left = i + 1;
            int right = Math.min(i + nums[i], length - 1);
            int min = (int) (Math.pow(10, 5) + 1);
            for (int j = left; j <= right; j++) {
                min = Math.min(min, ans[j]);
            }
            ans[i] = min + 1;
        }
        System.out.println(Arrays.toString(ans));

        return ans[0] < Math.pow(10, 4) * 3 + 1;
    }


    /**
     * 贪心
     */
    public boolean method_greedy(int[] nums) {

        int length = nums.length;
        int farthest = 0;

        for (int i = 0; i < length; i++) {
            if (i <= farthest) {
                farthest = Math.max(farthest, nums[i] + i);
                if (farthest >= length - 1) {
                    return true;
                }
            }
        }

        return false;
    }

}
