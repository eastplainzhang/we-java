package eastplain;

/**
 * 20201128
 * LCOF49
 *
 * method1
 * my method
 * overtime
 *
 * method2
 * leetcode method
 * Time     99
 * Storage  24
 */

public class LCOF49 {

    public static void main(String[] args) {
        NthUglyNumber n1 = new NthUglyNumber();
        System.out.println(n1.method2(10));
    }
}


class NthUglyNumber {

    public int method1(int n) {  // my method. overtime.
        int count = 0;
        int num = 0;
        while (count < n) {
            num += 1;
            if (check(num)) {
                count += 1;
            }
        }
        return num;
    }

    public boolean check(int num) {
        while (num > 1) {
            if (num % 2 == 0) { num /= 2; }
            else if (num % 3 == 0) { num /= 3; }
            else if (num % 5 == 0) { num /= 5; }
            else { return false; }
        }
        return true;  // This num is ugly num.
    }

    public int method2(int n) {
        int a = 0;
        int b = 0;
        int c = 0;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; ++i) {
            int n2 = dp[a] * 2;
            int n3 = dp[b] * 3;
            int n5 = dp[c] * 5;
            dp[i] = Math.min(Math.min(n2, n3), n5);

            // 这个地方要用三个if来判断，而不是用if else结构
            // 因为dp[i]可能不仅仅是一种乘积的结果
            // 比如6可以是3*2，也可以是2*3，这时候a和b都要+1
            if (dp[i] == n2) a++;
            if (dp[i] == n3) b++;
            if (dp[i] == n5) c++;
        }
        return dp[n - 1];
    }

}
