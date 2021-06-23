package eastplain;

import java.util.Arrays;


/**
 * 20201126
 * LC0492
 * Time     53
 * Storage  94
 */
public class LC0492 {

    public static void main(String[] args) {
        int demo_n = 2;
        ConsRect c1 = new ConsRect();
        System.out.println(Arrays.toString(c1.method(demo_n)));
    }
}


class ConsRect {

    public int[] method(int n) {

        int[] ans = new int[]{n, 1};
        for(int i = 1; i < Math.sqrt(n) + 1; ++i) {
            if(n / i >= i && n % i == 0 && (n / i - i) < (n - 1)) {
                ans[0] = n / i;
                ans[1] = i;
            }
        }
        return ans;
    }
}
