package eastplain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LCOF57 {

    public static void main(String[] args) {

        int[] demo_nums = new int[] {2, 7, 11, 15};
        int demo_target = 9;

        System.out.println(Arrays.deepToString(new FindContinuousSequence().method(15)));

    }
}


class TwoSum {

    public int[] method(int[] nums, int target) {

        int length = nums.length;
        int lp = 0;
        int rp = length - 1;
        int[] ans = new int[2];

        while(lp < rp){
            if(nums[lp] + nums[rp] < target){
                lp += 1;
            }
            else if(nums[lp] + nums[rp] > target){
                rp -= 1;
            }
            else{
                ans[0] = nums[lp];
                ans[1] = nums[rp];
                break;
            }
        }

        return ans;
    }
}


class FindContinuousSequence {

    /*
    我的方法
    Time     32
    Storage  7
    可以优化
     */
    public int[][] method_eastplain(int target) {

        if (target <= 2) {
            return new int[0][];
        }

        int[] nums = new int[target / 2 + 1];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i + 1;
        }

        List<int[]> ans = new ArrayList<>();

        int l = 0;
        int r = 1;

        while (l <= r - 1 && r < nums.length) {
            int sum = (nums[l] + nums[r]) * (nums[r] - nums[l] + 1) / 2;
            if (sum < target) { r += 1; }
            else if (sum > target) { l += 1;}
            else {
                int[] temp = new int[r - l + 1];
                if (temp.length >= 0) System.arraycopy(nums, l, temp, 0, temp.length);
                ans.add(temp);
                r += 1;
            }
        }

       return ans.toArray(new int[ans.size()][]);
    }

    public int[][] method(int target) {

        List<int[]> ans = new ArrayList<>();

        int l = 1;
        int r = 2;
        int sum = 3;

        while (l < r) {

            if (sum == target) {
                int[] temp = new int[r - l + 1];
                for (int i = 0; i < temp.length; ++i) {
                    temp[i] = i + l;
                }
                ans.add(temp);
            }

            if (sum >= target) {
                sum -= l;
                l += 1;
            }
            else {
                r += 1;
                sum += r;
            }
        }
        return ans.toArray(new int[0][]);
    }
}
