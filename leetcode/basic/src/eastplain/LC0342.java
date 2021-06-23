package eastplain;

import java.util.Arrays;

/**
 * @author EastPlain
 * @create 2021-4-07 12:13
 */
public class LC0342 {

    public static void main(String[] args) {
        int[] demo = new int[]{1, 5, 1, 1, 6, 4};
        new WiggleSort().method(demo);
    }
}


class WiggleSort {

    public void method(int[] nums) {

        int[] clone = nums.clone();
        Arrays.sort(clone);

        int index = nums.length;

        for (int i = 1; i < nums.length; i += 2) {
            nums[i] = clone[index - 1];
            index -= 1;
        }

        for (int i = 0; i < nums.length; i += 2) {
            nums[i] = clone[index - 1];
            index -= 1;
        }

        System.out.println(Arrays.toString(nums));
    }

}
