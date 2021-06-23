package eastplain;

public class LC0121 {

    public static void main(String[] args) {
        int[] demo = new int[]{7, 6, 4, 3, 1};
        System.out.println(new MaxProfit().method(demo));
    }
}


class MaxProfit {

    public int method(int[] prices) {

        int minnum = prices[0];
        int profit = 0;

        for (int i = 1; i < prices.length; ++i) {
            profit = Math.max(profit, prices[i] - minnum);
            minnum = Math.min(minnum, prices[i]);
        }

        return profit;
    }
}
