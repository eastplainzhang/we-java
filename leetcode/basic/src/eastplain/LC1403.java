package eastplain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author EastPlain
 * @create 2021-4-29 11:06
 */
public class LC1403 {
}


class MinSubSequence {

    public List<Integer> method(int[] nums) {

        List<Integer> ans = new ArrayList<>();

        Arrays.sort(nums);

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        int subSum = 0;
        int i = nums.length - 1;
        while (i >= 0 && i <= nums.length - 1 && subSum <= sum) {
            ans.add(nums[i]);
            subSum += nums[i];
            sum -= nums[i];
            i -= 1;
        }

        return ans;
    }
}
