package eastplain;


import java.util.Arrays;

/**
 * LC0016
 * 20201210
 * Time     95
 * Storage  50
 * 解题区方法
 */
public class LC0016 {

    public static void main(String[] args) {

        ThreeSumClosest tsc = new ThreeSumClosest();
        int[] demo_nums = new int[]{1, 1, 1, 1};
        int demo_t = 4;
        System.out.println(tsc.method(demo_nums, demo_t));
    }
}


class ThreeSumClosest {

    public int method(int[] nums, int target) {

        int best = (int) 1e7;

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; ++i) {

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int lp = i + 1;
            int rp = nums.length - 1;

            while (lp < rp) {
                int sum = nums[i] + nums[lp] + nums[rp];

                if (sum == target) {
                    return sum;
                }

                else {
                    best = update(sum, best, target);

                    if (sum > target) {
                        int rp_temp = rp - 1;
                        while (rp_temp > lp && nums[rp] == nums[rp_temp]) {
                            rp_temp -= 1;
                        }
                        rp = rp_temp;
                    }

                    else {
                        int lp_temp = lp + 1;
                        while (lp_temp < rp && nums[lp] == nums[lp_temp]) {
                            lp_temp += 1;
                        }
                        lp = lp_temp;
                    }
                }
            }
        }
        return best;
    }

    public int update(int num, int best, int target) {
        if (Math.abs(num - target) < Math.abs(best - target)) {
            return num;
        }
        return best;
    }
}

