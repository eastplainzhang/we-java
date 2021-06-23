package eastplain;

import java.util.HashMap;
import java.util.Map;

public class LC1784 {



}


class SumOfUnique {

    public int method(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int sum = 0;
        for (int num: map.keySet()) {
            if (map.get(num) == 1) {
                sum += num;
            }
        }

        return sum;
    }
}
