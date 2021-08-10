package base.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * 冒泡排序
 *
 * @author EastPlain
 * @date 2021/7/28 0:07
 */
public class BubbleSort {

    public int[] method(int[] nums) {

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }

        return nums;
    }

    @Test
    public void sortTest() {
        int[] demo = new int[]{53, 636, 64, 8, 3, 6, 23, 256, 231, 1, 7, 15, 123};
        System.out.println(Arrays.toString(method(demo)));
    }
}
