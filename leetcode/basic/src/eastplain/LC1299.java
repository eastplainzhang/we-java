package eastplain;

import java.util.Arrays;

public class LC1299 {

    public static void main(String[] args) {
        int[] demo = new int[]{17, 18, 5, 4, 6, 1};
        System.out.println(Arrays.toString(new ReplaceElements().method(demo)));
    }
}


class ReplaceElements {

    public int[] method(int[] arr) {

        int[] ans = new int[arr.length];
        ans[arr.length - 1] = arr[arr.length - 1];

        for (int i = arr.length - 2; i >= 0; --i) {
            int temp = arr[i + 1];
            ans[i] = Math.max(temp, ans[i + 1]);
        }

        ans[arr.length - 1] = -1;

        return ans;
    }
}
