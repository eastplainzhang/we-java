package eastplain;

import java.util.Arrays;

public class LC1029 {

    public static void main(String[] args) {
        int[][] demo = new int[][]{{10, 20} , {30, 200}, {400, 50}, {30, 20}};
        System.out.println(new TwoCitySchedCost().method(demo));
    }
}


class TwoCitySchedCost {

    public int method(int[][] costs) {

        int[] price_diff = new int[costs.length];
        int count = 0;

        for (int i = 0; i < costs.length; i++) {
            count += costs[i][1];
            price_diff[i] = costs[i][0] - costs[i][1];
        }

        Arrays.sort(price_diff);

        int diff_count = 0;
        for (int i = 0; i < costs.length / 2; i++) {
            diff_count += price_diff[i];
        }

        return count + diff_count;
    }
}
