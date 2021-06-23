package eastplain;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class LC0322 {

    public static void main(String[] args) {
        int[] demo = new int[]{94, 91, 377, 368, 207, 40, 415, 61};
        System.out.println(new CoinChange().method(demo, 19662));
    }
}


class CoinChange {

    /**
     * 超时
     */
    public int coinChange(int[] coins, int amount) {

        Set<Integer> set = new TreeSet<>();

        for (int coin : coins) {
            set.add(coin);
        }

        int ans = 0;
        ans = dp(coins, amount, set);

        return (ans >= 10001) ? -1 : ans;
    }

    public int dp(int[] coins, int amount, Set<Integer> set) {

        if (amount < 0) {
            return 10001;
        }

        if (amount == 0) {
            return 0;
        }

        if (set.contains(amount)) {
            return 1;
        }

        else {
            int time = 10001;
            for (int coin : coins) {
                time = Math.min(time, dp(coins, amount - coin, set));
            }
            return time + 1;
        }
    }

    /**
     * Time     31
     * Storage  67
     */
    public int method(int[] coins, int amount) {

        if (amount == 0) {
            return 0;
        }

        int[] store = new int[amount + 1];
        Arrays.fill(store, 10001);

        for (int coin : coins) {
            if (coin <= amount) {
                store[coin] = 1;
            }
        }

        for (int i = 0; i < store.length; i++) {
            if (store[i] != 1) {
                for (int coin : coins) {
                    if (coin <= i) {
                        store[i] = Math.min(store[i], store[coin] + store[i - coin]);
                    }
                }
            }
        }

        System.out.println(Arrays.toString(store));

        return (store[amount] < 10001) ? store[amount] : -1;
    }
}
