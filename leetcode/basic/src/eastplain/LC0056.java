package eastplain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author EastPlain
 * @create 2021-4-07 11:49
 */
public class LC0056 {

    public static void main(String[] args) {
        int[][] demo = new int[][]{{21, 3},{32, 6},{28, 10},{15, 18}};
        System.out.println(Arrays.deepToString(new Merge().method(demo)));
    }
}


class Merge {

    public int[][] method(int[][] intervals) {

        if (intervals.length == 0) {
            return new int[0][2];
        }

        // 重写排序
        Arrays.sort(intervals, (o1, o2) -> (o1[0] - o2[0]));
        // System.out.println("sorted  " + Arrays.deepToString(intervals));

        List<int[]> merged = new ArrayList<>();
        for (int[] interval : intervals) {
            int l = interval[0];
            int r = interval[1];
            if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < l) {
                merged.add(new int[]{l, r});
            } else {
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], r);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}
