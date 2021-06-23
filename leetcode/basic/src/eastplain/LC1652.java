package eastplain;

import java.util.Arrays;

public class LC1652 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Decrypt().method(new int[]{2, 4, 9, 3}, -2)));
    }
}


class Decrypt {

    public int[] method(int[] code, int k) {

        int length = code.length;

        int[] temp = new int[3 * length];
        for (int i = 0; i < length; ++i) {
            temp[i] = code[i];
            temp[i + length] = code[i];
            temp[i + 2 * length] = code[i];
        }

        int[] ans = new int[length];

        if (k > 0) {
            for (int i = 0; i < length; ++i) {
                ans[i] = sum(temp, length + i + 1, length + i + k + 1);
            }
        }
        else if (k < 0) {
            for (int i = 0; i < length; ++i) {
                ans[i] = sum(temp, length + i + k, length + i);
            }
        }
        else {
            for (int i = 0; i < length; ++i) {
                ans[i] = 0;
            }
        }

        return ans;
    }

    public int sum(int[] nums, int l, int r) {
        int sum = 0;
        for (int i = l; i < r; ++i) {
            sum += nums[i];
        }
        return sum;
    }
}
