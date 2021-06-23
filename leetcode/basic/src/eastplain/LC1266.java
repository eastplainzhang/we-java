package eastplain;


/**
 * 20201126
 * LC1266
 * Time     98
 * Storage  47
 */

public class LC1266 {

    public static void main(String[] args) {
        MinTimeToVisit m1 = new MinTimeToVisit();
        int[][] demo_points = new int[][]{{3, 2}, {-2, 2}};
        System.out.println(m1.method(demo_points));
    }
}


class MinTimeToVisit {

    public int method(int[][] points) {

        int length = points.length;
        int count = 0;
        for(int i = 0; i < length - 1; ++i) {
            count += Math.max(
                    Math.abs(points[i + 1][0] - points[i][0]),
                    Math.abs(points[i + 1][1] - points[i][1])
            );
        }
        return count;
    }
}
