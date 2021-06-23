package eastplain;

import java.util.HashMap;
import java.util.Map;

public class LC1207 {

    public static void main(String[] args) {
        int[] demo = new int[]{1, 2, 2, 1, 1, 3};
        System.out.println(new UniqueOccurrences().method(demo));
    }
}


class UniqueOccurrences {

    public boolean method(int[] arr) {

        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> count = new HashMap<>();

        for (int num: arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int num: map.values()) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        return map.size() == count.size();
    }
}
