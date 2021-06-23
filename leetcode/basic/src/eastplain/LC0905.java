package eastplain;

import java.util.Arrays;

public class LC0905 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new SortArrayByParity().method(new int[]{0, 1, 2})));
    }
}


class SortArrayByParity {

    public int[] method(int[] A) {

        int l = 0;
        int r = A.length - 1;

        while (l <= r) {
            if (A[l] % 2 == 1 && A[r] % 2 == 0) {
                int temp = A[l];
                A[l] = A[r];
                A[r] = temp;
                l += 1;
                r -= 1;
            }
            else if (A[l] % 2 == 1) {
                r -= 1;
            }
            else if (A[r] % 2 == 0) {
                l += 1;
            }
            else {
                l += 1;
                r -= 1;
            }
        }

        return A;
    }
}
