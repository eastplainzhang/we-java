package eastplain;

public class LCOF21 {
}


class Exchange {

    public int[] exchange(int[] nums) {

        int l = 0;
        int r = nums.length - 1;

        while (l < r) {
            if (nums[l] % 2 == 0 && nums[r] % 2 == 1) {
                int temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
                l += 1;
                r -= 1;
            }
            else if (nums[l] % 2 == 0) {
                r -= 1;
            }
            else if (nums[r] % 2 == 1) {
                l += 1;
            }
            else {
                l += 1;
                r -= 1;
            }
        }

        return nums;
    }
}