package eastplain;

import java.util.Arrays;


/**
 * 20201126
 * LC1464
 * Time     52
 * Storage  60
 */

public class LC1464 {

    public static void main(String[] args) {

        int[] demo_nums = new int[]{3, 4, 5, 2};
        MaxProduct m1 = new MaxProduct();
        System.out.println(m1.method(demo_nums));
    }

}


class MaxProduct {

    public int method(int[] nums) {
        int length = nums.length;
        Arrays.sort(nums);
        return (nums[length - 1] - 1) * (nums[length - 2] - 1);
    }

}
