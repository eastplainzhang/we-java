package eastplain;

import java.util.Arrays;

public class LC0560 {

    public static void main(String[] args) {
        int[] demo = new int[]{1, 2, 1, 2, 1};
        System.out.println(new SubarraySum().method(demo, 3));
    }
}


class SubarraySum {

    /*
    eastplain method
    利用前缀和和后缀和
    Time:     O(N^2)  5%
    Storage:  O(N)  55%
     */
    public int method(int[] nums, int k) {

        int length = nums.length;

        if (length == 1) {
            return nums[0] == k ? 1 : 0;
        }

        int[] l = new int[length];
        int[] r = new int[length];
        int sum = Arrays.stream(nums).sum();

        l[0] = 0;
        for (int i = 1; i < length; ++i) {
            l[i] = l[i - 1] + nums[i - 1];
        }

        r[length - 1] = 0;
        for (int i = length - 2; i >= 0; --i) {
            r[i] = r[i + 1] + nums[i + 1];
        }

        int count = 0;
        for (int i = 0; i < length; ++i) {
            for (int j = length - 1; j >= i; --j) {
                if (sum - l[i] - r[j] == k) {
                    count += 1;
                }
            }
        }

        return count;
    }


    /*
    前缀和+哈希
     */
    // TODO: 2021/4/3
    public int method_hash(int[] nums, int k) {

        return 0;
    }

}
