package eastplain;

/**
 * LCMS0801
 * 20201212
 * Time     43
 * Storage  77
 * 动态规划
 * 这道题需要注意的地方是取模
 * 只取模一次还是会越界
 * 要先取两次
 */
public class LCMS0801 {
    public static void main(String[] args) {
        WaysToStep w = new WaysToStep();
        System.out.println(w.method(61));
    }
}


class WaysToStep {

    public int method(int n) {
        int ans = 0;
        if (n == 1) { ans = 1; }
        else if (n == 2) { ans = 2; }
        else if (n == 3) { ans = 4; }
        else {
            int a = 1;
            int b = 2;
            int c = 4;
            for (int i = 4; i < n + 1; ++i) {
                ans = (a + (b + c) % 1000000007) % 1000000007;
                a = b;
                b = c;
                c = ans;
            }
        }
        return ans;
    }
}
