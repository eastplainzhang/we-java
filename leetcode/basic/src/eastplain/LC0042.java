package eastplain;

import java.util.Arrays;

/**
 * @author EastPlain
 * @create 2021-4-16 11:36
 */
public class LC0042 {

    public static void main(String[] args) {
        int[] height = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(new TrapTest().method(height));
    }
}


class TrapTest {

    public int method(int[] height) {

        int length = height.length;

        if (length <= 2) {
            return 0;
        }

        int[] left = new int[length];
        int[] right = new int[length];
        int[] holder = new int[length];

        left[0] = 0;
        for (int i = 1; i < length - 1; ++i) {
            left[i] = Math.max(left[i - 1], height[i - 1]);
        }

        right[length - 1] = 0;
        for (int i = length - 2; i >= 0; --i) {
            right[i] = Math.max(right[i + 1], height[i + 1]);
        }

        holder[0] = 0;
        holder[length - 1] = 0;
        for (int i = 1; i < length - 1; ++i) {
            int temp = Math.min(left[i], right[i]) - height[i];
            holder[i] = Math.max(temp, 0);
        }
        System.out.println(Arrays.toString(holder));

        int count = 0;
        for (int h : holder) {
            count += h;
        }

        return count;
    }
}
