package eastplain;

import java.util.Arrays;

public class LC0075 {

    public static void main(String[] args) {
        int[] demo = new int[]{2, 0, 2, 1, 1, 0};
        new SortColors().method(demo);
    }
}


class SortColors {

    public void method(int[] nums) {

        helper(nums, 0, 1);
        helper(nums, 0, 2);
        helper(nums, 1, 2);
        System.out.println(Arrays.toString(nums));
    }

    public void helper(int[] nums, int lower, int upper) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            if (nums[l] == upper && nums[r] == lower) {
                int temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
                l += 1;
                r -= 1;
            }
            else if (nums[l] == upper) {
                r -= 1;
            }
            else if (nums[r] == lower) {
                l += 1;
            }
            else {
                l += 1;
                r -= 1;
            }
        }
    }
}
