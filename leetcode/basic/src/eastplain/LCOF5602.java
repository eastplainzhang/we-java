package eastplain;

import java.util.Arrays;

/**
 * LCOF5602
 * 20200125
 *Time     67
 *Storage  52
 */
public class LCOF5602 {
}


class SingleNumber {

    public int method(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != nums[i + 1]) {
                if (i == 0) {
                    return nums[i];
                }
                if (nums[i] != nums[i - 1]) {
                    return nums[i];
                }
            }
        }
        return nums[nums.length - 1];
    }
}
