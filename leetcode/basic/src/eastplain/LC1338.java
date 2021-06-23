package eastplain;

import java.util.*;

public class LC1338 {

    public static void main(String[] args) {
        int[] demo = new int[]{3, 3, 3, 3, 5, 5, 5, 2, 2, 7};
        System.out.println(new MinSetSize().method(demo));
    }
}


class MinSetSize {
    public int method(int[] arr) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer> list = new ArrayList<>();
        for (int key : map.keySet()) {
            list.add(map.get(key));
        }

        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        int count = 0;
        int ans = 0;
        for (int i : list) {
            count += i;
            ans += 1;
            if (count >= arr.length / 2) {
                return ans;
            }
        }

        return ans;
    }
}
