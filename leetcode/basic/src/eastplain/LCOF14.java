package eastplain;

import java.util.Arrays;

/**
 * @author EastPlain
 * @create 2021-4-15 14:11
 */

public class LCOF14 {

    public static void main(String[] args) {
        System.out.println(new CuttingRope01().method(10));
    }
}

/*
dp
 */
class CuttingRope01 {

    public int method(int n) {

        int[] ans = new int[n];
        ans[0] = 1;

        for (int i = 2; i <= n; ++i) {
            int max = 0;
            for (int j = 1; j < i; ++j) {
                max = Math.max(max, j * Math.max(ans[i - j - 1], i - j));
            }
            ans[i - 1] = max;
        }
        System.out.println(Arrays.toString(ans));

        return ans[n - 1];
    }
}


/*
贪心 + 大数循环求余数防止越界
 */
class CuttingRope02 {

    public int method(int n) {

        if(n <= 3) {
            return n - 1;
        }

        int b = n % 3;
        int p = 1000000007;

        long ret = 1;
        int lineNums = n / 3;

        for(int i = 1; i < lineNums; i++)
            ret = 3 * ret % p;

        if(b == 0) {
            return (int)(ret * 3 % p);
        }

        if(b == 1) {
            return (int)(ret * 4 % p);
        }

        return (int)(ret * 6 % p);
    }
}
