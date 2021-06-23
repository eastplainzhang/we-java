package eastplain;

import java.util.Arrays;

/**
 * greedy
 */
public class LC1262 {

    public static void main(String[] args) {
        int[] demo = new int[]{2, 6, 2, 2, 7};
        System.out.println(new MaxSumDivThree().maxSumDivThree(demo));
    }
}


class MaxSumDivThree {
    public int maxSumDivThree(int[] nums) {

        int length = nums.length;

        Arrays.sort(nums);

        int nums_sum = 0;
        int res_sum = 0;

        int[] res = new int[length];

        for (int i = 0; i < length; i++) {
            nums_sum += nums[i];
            res[i] = nums[i] % 3;
            res_sum += res[i];
        }

        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(res));

        if (res_sum % 3 == 0) {
            return nums_sum;
        }
        else if (res_sum % 3 == 1) {
            int temp_1 = 0;
            int temp_2 = 0;
            int count_1 = 0;
            int count_2 = 0;
            for (int i = 0; i < length; i++) {
                if (res[i] == 1) {
                    temp_1 = nums[i];
                    count_1 += 1;
                    break;
                }
            }
            for (int i = 0; i < length; i++) {
                if (res[i] == 2) {
                    temp_2 += nums[i];
                    count_2 += 1;
                    if (count_2 == 2) {
                        break;
                    }
                }
            }
            if (count_1 < 1) {
                return nums_sum - temp_2;
            }
            if (count_2 < 2) {
                return nums_sum - temp_1;
            }
            return nums_sum - Math.min(temp_1, temp_2);
        }
        else {
            int temp_2 = 0;
            int temp_1 = 0;
            int count_1 = 0;
            int count_2 = 0;
            for (int i = 0; i < length; i++) {
                if (res[i] == 2) {
                    temp_2 = nums[i];
                    count_2 += 1;
                    break;
                }
            }
            for (int i = 0; i < length; i++) {
                if (res[i] == 1) {
                    temp_1 += nums[i];
                    count_1 += 1;
                    if (count_1 == 2) {
                        break;
                    }
                }
            }
            if (count_2 < 1) {
                return nums_sum - temp_1;
            }
            if (count_1 < 2) {
                return nums_sum - temp_2;
            }
            return nums_sum - Math.min(temp_1, temp_2);
        }
    }
}



