package eastplain;

public class LC0279 {

    public static void main(String[] args) {

        for (int i = 0; i <= 10000; i++) {
            System.out.println(i + "  " + new NumSquares().method(i));
        }
        // System.out.println(new NumSquares().method(10000));
    }
}


class NumSquares {

    public int method(int n) {
        if ((int) Math.pow((int) Math.sqrt(n), 2) == n) {
            return 1;
        }

        int[] ans = new int[n + 1];
        ans[0] = 1001;

        for (int i = 1; i <= n; ++i) {
            if ((int) Math.pow((int) Math.sqrt(i), 2) == i) {
                ans[i] = 1;
            }
            else {
                int temp = 1001;
                for (int j = 1; j < i; j++) {
                    if (ans[j] == 1) {
                        temp = Math.min(temp, ans[i - j] + 1);
                    }
                    if (temp == 2) {
                        break;
                    }
                }
                ans[i] = temp;
            }
        }
        // System.out.println(Arrays.toString(ans));

        return ans[n];
    }
}