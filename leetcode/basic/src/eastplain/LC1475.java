package eastplain;

import java.util.Arrays;

public class LC1475 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new FinalPrices().method(new int[]{8, 4, 6, 2, 3})));
    }
}


class FinalPrices {

    public int[] method(int[] prices) {

        if (prices.length == 1) {
            return prices;
        }

        for (int i = 0; i < prices.length - 1; ++i) {
            for (int j = i + 1; j < prices.length; ++j) {
                if (prices[i] >= prices[j]) {
                    prices[i] -= prices[j];
                    break;
                }
            }
        }

        return prices;
    }
}
