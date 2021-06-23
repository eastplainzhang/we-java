package eastplain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC0922 {

    public static void main(String[] args) {
        int[] demo = new int[]{4, 2, 5, 7};
        System.out.println(Arrays.toString(new SortArrayByParityII().method(demo)));
    }
}


class SortArrayByParityII {

    public int[] method(int[] nums) {

        int length = nums.length;
        int[] ans = new int[length];
        List<Integer> even = new ArrayList<>();
        List<Integer> odd = new ArrayList<>();

        for (int num: nums) {
            if (num % 2 == 0) {
                even.add(num);
            }
            else {
                odd.add(num);
            }
        }

        for (int i = 0; i < length / 2; i++) {
            ans[2 * i] = even.get(i);
            ans[2 * i + 1] = odd.get(i);
        }

        return ans;
    }
}
