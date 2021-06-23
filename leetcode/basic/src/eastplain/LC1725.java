package eastplain;

import java.util.HashMap;
import java.util.Map;

public class LC1725 {

    public static void main(String[] args) {
        int[][] demo = new int[][]{{5, 8}, {3, 9}, {5, 12}, {16, 5}};
        System.out.println(new CountGoodRectangles().method(demo));
    }
}


class CountGoodRectangles {

    public int method(int[][] rectangles) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int[] rectangle : rectangles) {
            int len = Math.min(rectangle[0], rectangle[1]);
            map.put(len, map.getOrDefault(len, 0) + 1);
        }

        int count = 0;
        int temp = 0;
        for (int len : map.keySet()) {
            if (len > temp) {
                temp = len;
                count = map.get(len);
            }
        }

        return count;
    }
}

