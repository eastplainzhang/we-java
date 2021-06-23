package eastplain;

/**
 * LCOF42
 * 20201212
 * Time     99
 * Storage  81
 */
public class LCOF42 {

    public static void main(String[] args) {
        MaxSubArray msa = new MaxSubArray();
        int[] demo = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(msa.method_advanded(demo));
    }
}


class MaxSubArray {

    /**
     * 动态规划
     * 时间复杂度  O(n)
     * 空间复杂度  O(n)
     */
    public int method(int[] nums) {

        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        int max = sum[0];
        for (int i = 1; i < nums.length; ++i) {
            sum[i] = nums[i] + Math.max(0, sum[i - 1]);
            max = Math.max(max, sum[i]);
        }
        return max;
    }

    /**
     * 对method的改进
     * 空间复杂度改进为O(1)
     */
    public int method_advanded(int[] nums) {
        int temp_last = nums[0];
        int temp_now;
        int max = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            temp_now = nums[i] + Math.max(0, temp_last);
            max = Math.max(max, temp_now);
            temp_last = temp_now;
        }
        return max;
    }
}
