package eastplain;

import java.util.Arrays;

/**
 * LCOF40
 * 20201204
 * Time     62
 * Storage  66
 */
public class LCOF40 {

    public static void main(String[] args) {
        GetLastNumber g1 = new GetLastNumber();
        int[] demo = new int[]{0, 1, 2, 1};
        System.out.println(Arrays.toString(g1.method(demo, 1)));
    }
}


class GetLastNumber {

    public int[] method(int[] arr, int k) {
        Arrays.sort(arr);
        int[] ans = new int[k];
        if (k >= 0) System.arraycopy(arr, 0, ans, 0, k);
        return ans;
    }
}
