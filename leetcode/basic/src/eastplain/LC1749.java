package eastplain;


/**
 * greedy
 */
public class LC1749 {

    public static void main(String[] args) {

        int[] demo = new int[]{1, -3, 2, 3, -4};
        System.out.println(new MaxAbsoluteSum().maxAbsoluteSum(demo));
    }
}


class MaxAbsoluteSum {
    public int maxAbsoluteSum(int[] nums) {
        
        int length = nums.length;

        int[] store_a = new int[length];
        int[] store_b = new int[length];
        store_a[0] = Math.max(0, nums[0]);
        store_b[0] = Math.min(0, nums[0]);

        for (int i = 1; i < length; i++) {
            store_a[i] = Math.max(0, store_a[i - 1] + nums[i]);
            store_b[i] = Math.min(0, store_b[i - 1] + nums[i]);
        }

        int ans_a = 0;
        int ans_b = 0;
        for (int i = 0; i < length; i++) {
            ans_a = Math.max(ans_a, store_a[i]);
            ans_b = Math.min(ans_b, store_b[i]);
        }

        return Math.max(ans_a, Math.abs(ans_b));
    }
}
