package eastplain;

/**
 * @author EastPlain
 * @create 2021-4-15 15:36
 */

public class LC0198 {

    public static void main(String[] args) {

        int[] demo = new int[]{2, 7, 9, 3, 1};
        System.out.println(new Rob01().rob_dp(demo));
    }
}

class Rob01 {

    /*
    这道题用递归会超时，选择建立数组
     */
    public int rob_dp(int[] nums) {
        int length = nums.length;

        if (length == 0) {
            return 0;
        }
        if (length == 1) {
            return nums[0];
        }

        int[] ans = new int[length];
        ans[0] = nums[0];
        ans[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < length; ++i) {
            ans[i] = Math.max(ans[i - 2] + nums[i], ans[i - 1]);
        }

        return ans[length - 1];
    }

}
