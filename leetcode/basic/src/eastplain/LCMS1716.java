package eastplain;

/**
 * LCMS1716
 * 20201212
 * Time     100
 * Storage  60
 * 动态规划
 * 自己想出来的
 */
public class LCMS1716 {

    public static void main(String[] args) {
        Massage m = new Massage();
        int[] demo = new int[]{2, 1, 1, 2};
        System.out.println(m.method(demo));
    }
}


class Massage {

    public int method(int[] nums) {
        int len = nums.length;

        if (len == 0) { return 0; }
        else if (len == 1) { return nums[0]; }
        else if (len == 2) { return Math.max(nums[0], nums[1]); }

        int temp_m = nums[0];
        int temp_n = Math.max(nums[0], nums[1]);
        int temp = 0;
        int max = Math.max(temp_m, temp_n);

        for (int i = 2; i < nums.length; ++i) {
            temp = Math.max(temp_m + nums[i], temp_n);
            temp_m = temp_n;
            temp_n = temp;
            max = Math.max(max, temp);
        }
        return max;
    }
}
