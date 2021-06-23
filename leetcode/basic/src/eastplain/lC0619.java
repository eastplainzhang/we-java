package eastplain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class lC0619 {
}


class MajorityElement {

    public int method_01(int[] nums) {

        Arrays.sort(nums);
        return (nums[nums.length / 2]);

    }

    public int method_02(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num: nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            }
            else {
                map.put(num, 1);
            }
        }

        for (int key: map.keySet()) {
            if (map.get(key) > nums.length / 2) {
                return key;
            }
        }

        return 0;
    }
}
