package eastplain;

import java.util.Scanner;

/**
 * @author EastPlain
 * @create 2021-4-15 10:19
 */

public class LC0045 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {

            int length = sc.nextInt();
            if (length == 0) {
                System.out.println(0);
                continue;
            }
            if (length == 1) {
                System.out.println(1);
                continue;
            }

            int[] nums = new int[length];
            for (int i = 0; i < length; ++i) {
                nums[i] = sc.nextInt();
            }

            System.out.println(dp(nums));

        }
    }


    public static int dp(int[] nums) {

        int[] steps = new int[nums.length];
        for (int i = 0; i < steps.length; ++i) {
            steps[i] = 1000;
        }

        for (int i = nums.length - 1; i >= 0; --i) {
            if (nums[i] == 0) {
                continue;
            }
            if (nums[i] + i >= nums.length - 1) {
                steps[i] = 1;
            }
            else {
                int left = i + 1;
                int right = i + nums[i];
                steps[i] = calMin(steps, left, right) + 1;
            }
        }

        // System.out.println(Arrays.toString(steps));
        return steps[0];
    }


    public static int calMin(int[] steps, int left, int right) {
        int min = steps[left];
        for (int i = left; i <= right; ++i) {
            min = Math.min(min, steps[i]);
        }
        return min;
    }
}
