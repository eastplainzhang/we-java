package eastplain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author EastPlain
 * @create 2021-4-01 16:39
 */
public class LCOF56 {

    public static void main(String[] args) {
        int[] demo = new int[]{4, 1, 4, 6};
        System.out.println(Arrays.toString(new SingleNumbers().method_sort(demo)));
    }
}


class SingleNumbers {

    public int[] method_map(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[2];

        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int count = 0;
        for (int num: map.keySet()) {
            if (map.get(num) == 1) {
                ans[count] = num;
                count += 1;
            }
        }

        return ans;
    }

    public int[] method_sort(int[] nums) {
        int[] ans = new int[2];
        int count = 0;

        Arrays.sort(nums);

        if (nums[0] != nums[1]) {
            ans[count] = nums[0];
            count += 1;
        }

        if (nums[nums.length - 1] != nums[nums.length - 2]) {
            ans[count] = nums[nums.length - 1];
            count += 1;
        }

        for (int i = 1; i < nums.length - 1; ++i) {
            if (nums[i] != nums[i - 1] && nums[i] != nums[i + 1]) {
                ans[count] = nums[i];
                count += 1;
            }
        }

        return ans;
    }
}
