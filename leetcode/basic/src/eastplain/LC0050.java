package eastplain;

public class LC0050 {
    public static void main(String[] args) {
        System.out.println(new MyPowTest().method(0.00001, 2147483647));
    }
}


class MyPowTest {

    public double method(double x, int n) {
        if (n < 0) {
            return (double)1 / quickPow(x, -n);
        }
        else {
            return quickPow(x, n);
        }
    }

    public double quickPow(double x, int n) {
        if (n == 0) {
            return 1;
        }

        double temp = quickPow(x, n / 2);
        if (n % 2 == 0) {
            return temp * temp;
        }
        else {
            return temp * temp * x;
        }
    }
}
