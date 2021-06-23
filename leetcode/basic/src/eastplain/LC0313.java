package eastplain;

/**
 * LCOF49
 * 20201204
 * Time     40
 * Storage  27
 */

public class LC0313 {

    public static void main(String[] args) {
        NthSuperUglyNumber nsum = new NthSuperUglyNumber();
        int n_demo = 12;
        int[] p_demo = new int[]{2, 7, 13, 19};
        System.out.println(nsum.method(n_demo, p_demo));
    }
}


class NthSuperUglyNumber {

    public int method(int n, int[] primes) {

        int[] ans = new int[n];  // 新建一个数组存储每一次的结果
        ans[0] = 1;  // 初始化，对于每一个质数，第一次都先乘ans中的第一个数1

        int priCount = primes.length;  // 质数的个数

        int[] priLocation = new int[priCount];  // 对于一个质数，要乘的数位于ans的位置
        for (int j = 0; j < priCount; ++j) {
            priLocation[j] = 0;
        }

        for (int i = 1; i < n; ++i) {
            int[] temp = new int[priCount];
            for (int j = 0; j < priCount; ++j) {
                temp[j] = ans[priLocation[j]] * primes[j];  // 所有的乘积的结果
            }
            ans[i] = getMin(temp);  // 取最小的一个作为本次的结果
            System.out.println("i: " + i + "ans: " + ans[i]);
            for (int j = 0; j < priCount; ++j) {
                if (ans[i] == ans[priLocation[j]] * primes[j]) {  // 满足条件的质数要乘的数的位置加1
                    priLocation[j] += 1;
                }
            }
        }

        return ans[n - 1];
    }

    public int getMin(int[] arr) {
        int length = arr.length;
        int mininum = arr[0];
        for (int j : arr) {
            if (j < mininum) { mininum = j; }
        }
        return mininum;
    }
}
