package eastplain;

import java.util.Arrays;

/**
 * LCOF03
 * 20210125
 * Time     58
 * Storage  51
 */
public class LCOF03 {

    public static void main(String[] args) {
        FindRepeatNumber f = new FindRepeatNumber();
        int[] demo = new int[]{9, 4, 1, 1, 6};
        System.out.println(f.method(demo));
    }
}


class FindRepeatNumber {

    public int method(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return nums[i];
            }
        }
        return 0;
    }
}
