package eastplain;

import java.util.Arrays;


/**
 * LCMS1606
 * 20201210
 * Time     96
 * Storage  99
 * 要注意-2147483648的数值越界问题
 */
public class LCMS1606 {
    public static void main(String[] args) {
        SmallestDifference sd = new SmallestDifference();
        int[] demo_a = new int[]{-2147483648, 1};
        int[] demo_b = new int[]{2147483647, 0};
        System.out.println(sd.method(demo_a, demo_b));
    }
}


class SmallestDifference {

    public int method(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        int[] temp = new int[a.length + b.length];
        for (int i = 0; i < a.length; ++i) {
            temp[i] = a[a.length -1 - i];
        }
        if (temp.length - a.length >= 0)
            System.arraycopy(b, 0, temp, a.length, temp.length - a.length);
        System.out.println("temp: " + Arrays.toString(temp));

        int best = 2147483647;

        int lp = 0;
        int rp = temp.length - 1;
        while (lp < a.length && rp >= a.length && rp < temp.length) {
            System.out.println("best: " + best);
            if (temp[rp] - temp[lp] == 0) {
                return 0;
            }
            else if (temp[rp] - temp[lp] < 0) {
                int sum = Math.abs(temp[rp] - temp[lp]);
                if (sum < best && sum != -2147483648) {
                    best = sum;
                }
                int lp_temp = lp + 1;
                while (lp_temp < a.length && temp[lp] == temp[lp_temp]) {
                    lp_temp += 1;
                }
                lp = lp_temp;
            }
            else {
                int sum = Math.abs(temp[rp] - temp[lp]);
                if (sum < best && sum != -2147483648) {
                    best = sum;
                }
                int rp_temp = rp -1;
                while (rp_temp >= a.length && temp[rp] == temp[rp_temp]) {
                    rp_temp -= 1;
                }
                rp = rp_temp;
            }
        }

        return best;
    }
}
