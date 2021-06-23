package eastplain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author EastPlain
 * @create 2021-4-06 10:48
 */

public class LC0229 {

    public static void main(String[] args) {
        int[] domo = new int[]{1, 1, 1, 3, 3, 2, 2, 2};
        System.out.println(new MajorityElementII().method_vote(domo));
    }
}


class MajorityElementII {

    // HashMap
    public List<Integer> method_hashmap(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        int length = nums.length;

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int num : map.keySet()) {
            if (map.get(num) > length / 3) {
                ans.add(num);
            }
        }

        return ans;
    }


    // 摩尔投票法
    public List<Integer> method_vote(int[] nums) {
        List<Integer> ans = new ArrayList<>();

        if (nums.length == 1) {
            ans.add(nums[0]);
            return ans;
        }

        int num_1 = 0;
        int num_2 = 0;
        int count_1 = 0;
        int count_2 = 0;

        for (int num : nums) {
            if (num == num_1) {
                count_1 += 1;
                continue;
            }

            if (num == num_2) {
                count_2 += 1;
                continue;
            }

            if (count_1 == 0) {
                num_1 = num;
                count_1 += 1;
                continue;
            }


            if (count_2 == 0) {
                num_2 = num;
                count_2 += 1;
                continue;
            }

            count_1 -= 1;
            count_2 -= 1;
        }

        count_1 = 0;
        count_2 = 0;

        for (int num : nums) {
            if (num == num_1) {
                count_1 += 1;
            }
            else if (num == num_2) {
                count_2 += 1;
            }
        }

        if (count_1 > nums.length / 3) {
            ans.add(num_1);
        }

        if (count_2 > nums.length / 3) {
            ans.add(num_2);
        }

        return ans;
    }
}
