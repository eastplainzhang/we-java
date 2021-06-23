package eastplain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author EastPlain
 * @create 2021-4-06 18:10
 */
public class LC1630 {
    public static void main(String[] args) {
        int[] nums = new int[]{-12, -9, -3, -12, -6, 15 , 20, -25, -20, -15, -10};
        int[] l = new int[]{0, 1, 6, 4, 8, 7};
        int[] r = new int[]{4, 4 ,9, 7, 9, 10};
        System.out.println(new CheckArithmeticSubarrays().method(nums, l, r));
    }
}


class CheckArithmeticSubarrays {

    public List<Boolean> method(int[] nums, int[] l, int[] r) {

        List<Boolean> ans = new ArrayList<>();
        int length = l.length;

        for (int i = 0; i < length; i++) {
            System.out.println("i  " + i);
            int left = l[i];
            int right = r[i];
            int[] temp = new int[right - left + 1];
            System.arraycopy(nums, l[i], temp, 0, temp.length);
            Arrays.sort(temp);

            // System.out.println(Arrays.toString(temp));

            ans.add(true);
            for (int j = 1; j < temp.length; j++) {
                if (temp[j] - temp[j - 1] != temp[1] - temp[0]) {
                    ans.remove(i);
                    ans.add(false);
                    break;
                }
            }
            // System.out.println(ans);
        }
        return ans;
    }
}
