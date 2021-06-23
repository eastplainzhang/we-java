package eastplain;

public class LC0152 {
}


class MaxProductTest {

    public int method(int[] nums) {

        if (nums.length == 1) {
            return nums[0];
        }

        int length = nums.length;
        int[] max = new int[length];
        int[] min = new int[length];
        int ans = nums[0];

        max[0] = nums[0];
        min[0] = nums[0];

        for (int i = 1; i < length; ++i) {
            int max_temp = Math.max(max[i - 1] * nums[i], min[i - 1] * nums[i]);
            int min_temp = Math.min(max[i - 1] * nums[i], min[i - 1] * nums[i]);
            max[i] = Math.max(nums[i], max_temp);
            min[i] = Math.min(nums[i], min_temp);
            ans = Math.max(ans, max[i]);
        }

        return ans;
    }
}
