package eastplain;

import java.util.Arrays;


/**
 * 20201126
 * LCMS1704
 * Time     17
 * Storage  76
 */

public class LCMS1704 {

    public static void main(String[] args) {

        MissNum m1 = new MissNum();
        int[] demo_nums = new int[]{0};
        System.out.println(m1.method(demo_nums));
    }
}


class MissNum {

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