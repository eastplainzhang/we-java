package eastplain;

import java.util.Arrays;

/**
 * LCMS1714
 * 20201204
 * Time     69
 * Storage  54
 */
public class LCMS1714 {

    public static void main(String[] args) {
        SmallEstK sek = new SmallEstK();
        int[] demo = new int[]{3, 4, 6, 2, 0, 9, 8, 7};
        System.out.println(Arrays.toString(sek.method(demo, 3)));
    }
}


class SmallEstK {

    public int[] method(int[] arr, int k) {
        int[] ans = new int[k];
        Arrays.sort(arr);
        if (k >= 0) System.arraycopy(arr, 0, ans, 0, k);
        return ans;
    }

}
