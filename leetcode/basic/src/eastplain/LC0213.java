package eastplain;

/**
 * @author EastPlain
 * @create 2021-4-19 9:28
 */

public class LC0213 {

    public static void main(String[] args) {
        int[] dmeo = new int[]{0};
        System.out.println(new Rob02().rob(dmeo));
    }
}


class Rob02 {

    public int rob(int[] nums) {

        int length = nums.length;

        if (length == 1) {
            return nums[0];
        }

        // int[] nums_1 = new int[length];
        // int[] nums_2 = new int[length];
        //
        // System.arraycopy(nums, 0, nums_1, 0, length - 1);
        // System.arraycopy(nums, 1, nums_2, 1, length - 1);

        int[] ans_1 = new int[length];
        int[] ans_2 = new int[length];

        ans_1[0] = nums[0];
        ans_1[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < length - 1; i++) {
            ans_1[i] = Math.max(ans_1[i - 2] + nums[i], ans_1[i - 1]);
        }

        ans_2[0] = 0;
        ans_2[1] = nums[1];
        for (int i = 2; i < length; i++) {
            ans_2[i] = Math.max(ans_2[i - 2] + nums[i], ans_2[i - 1]);
        }

        return Math.max(ans_1[length - 2], ans_2[length - 1]);
    }
}
