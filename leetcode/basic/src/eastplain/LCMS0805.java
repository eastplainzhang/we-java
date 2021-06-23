package eastplain;

/**
 * LCMS0805
 * 20201204
 *
 * method1: not recursion
 * Time     100
 * Storage  52
 *
 * method2: recursion
 * Time     100
 * Storage  89
 */

public class LCMS0805 {

    public static void main(String[] args) {
        Multiply m = new Multiply();
        System.out.println(m.method2(0, 7));
    }
}


class Multiply {

    public int method1(int A, int B) {
        int m = Math.max(A, B);
        int n = Math.min(A, B);
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            ans += m;
        }
        return ans;
    }

    public int method2(int A, int B) {
        int m = Math.max(A, B);
        int n = Math.min(A, B);
        if (n == 0) { return 0; }
        else { return m + method2(n - 1, m); }
    }

}
