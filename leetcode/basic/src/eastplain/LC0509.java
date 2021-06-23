package eastplain;


/**
 * 20201125
 * LC0509
 */

public class LC0509 {

    public static void main(String[] args) {

        int demo_N = 23;
        Fib f1 = new Fib();
        System.out.println(f1.method(demo_N));

    }
}


class Fib {

    public int method(int N) {

        int[] arr = new int[N + 1];

        if (N == 0) { return 0; }

        else if (N == 1) { return 1; }

        else {
            arr[0] = 0;
            arr[1] = 1;
            for (int i = 2; i < N + 1; i++) {
                arr[i] = arr[i - 1] + arr[i - 2];
            }
            return arr[N];
        }
    }
}
