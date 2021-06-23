package eastplain;

/**
 * LC0746
 * 20201212
 * Time     100
 * Storage  87
 * 动态规划
 * 看的评论区的方法
 * 关键在于从后往前算
 */
public class LC0746 {

    public static void main(String[] args) {
        MinCostClimbingStairs mccs = new MinCostClimbingStairs();
        int[] demo = new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println(mccs.method(demo));
    }
}


class MinCostClimbingStairs {

    public int method(int[] cost) {
        int len = cost.length;
        int f1 = 0;
        int f2 = 0;
        for (int i = len - 1; i >= 0; --i) {
            int f0 = cost[i] + Math.min(f1, f2);
            f2 = f1;
            f1 = f0;
        }
        return Math.min(f1, f2);
    }
}