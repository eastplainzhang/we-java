package eastplain;

/**
 * @author EastPlain
 * @create 2021-4-19 10:43
 */
public class LC0877 {
}


class StoneGame {

    public boolean stoneGame(int[] piles) {

        int length = piles.length;

        int[][] dp = new int[length][length];

        for (int i = 0; i < length; i++) {
            dp[i][i] = piles[i];
        }

        for (int j = 1; j < length; ++j) {
            for (int i = j - 1; i >= 0; --i) {
                dp[i][j] = Math.max(piles[i] - dp[i + 1][j], piles[j] - dp[i][j - 1]);
            }
        }

        return dp[0][length - 1] > 0;
    }
}
