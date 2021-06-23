package eastplain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author EastPlain
 * @create 2021-4-06 18:47
 */
public class LC0350 {
}


class Intersect {

    /*
    hashmap
    Time     21
    Storage  50
     */
    public int[] method(int[] nums1, int[] nums2) {
        List<Integer> temp = new ArrayList<>();
        Map<Integer, Integer> n1 = new HashMap<>();
        Map<Integer, Integer> n2 = new HashMap<>();

        for (int num : nums1) {
            n1.put(num, n1.getOrDefault(num, 0) + 1);
        }

        for (int num : nums2) {
            n2.put(num, n2.getOrDefault(num, 0) + 1);
        }

        for (int num : n1.keySet()) {
            int count = Math.min(n1.get(num), n2.getOrDefault(num, 0));
            for (int i = 0; i < count; ++i) {
                temp.add(num);
            }
        }

        int[] ans = new int[temp.size()];
        for (int i = 0; i < temp.size(); ++i) {
            ans[i] = temp.get(i);
        }

        return ans;
    }
}
