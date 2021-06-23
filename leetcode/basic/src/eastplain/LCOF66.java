package eastplain;

import java.util.Arrays;

public class LCOF66 {

    public static void main(String[] args) {
        int[] demo = new int[]{1};
        System.out.println(Arrays.toString(new ConstructArr().method(demo)));
    }

}


class ConstructArr {

    public int[] method(int[] a) {

        int length = a.length;

        if (length <= 1) {
            return a;
        }

        int[] l = new int[length];
        int[] r = new int[length];
        int[] ans = new int[length];

        l[0] = 1;
        for (int i = 1; i < length; i++) {
            l[i] = l[i - 1] * a[i - 1];
        }

        r[length - 1] = 1;
        for (int i = length - 2; i >= 0; i--) {
            r[i] = r[i + 1] * a[i + 1];
        }

        for (int i = 0; i < length; i++) {
            ans[i] = l[i] * r[i];
        }

        return ans;
    }
}
