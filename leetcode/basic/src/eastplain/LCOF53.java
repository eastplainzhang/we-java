package eastplain;

import java.util.Arrays;

/**
 * 20201128
 * LCOF53
 * Time     100
 * Storage  90
 */


public class LCOF53 {

    public static void main(String[] args) {

        MissingNum m1 = new MissingNum();
        int[] demo_nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(m1.method(demo_nums));
    }
}


class MissingNum {

    public int method(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        if(nums[0] != 0) { return 0; }
        if(nums[length - 1] != length) { return length; }
        for(int i = 1; i < length; ++i) {
            if(nums[i] - nums[i - 1] != 1) {
                return i;
            }
        }
        return 0;
    }
}
