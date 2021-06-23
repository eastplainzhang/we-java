package eastplain;

public class LCOF16 {

    public static void main(String[] args) {
        MyPow mp = new MyPow();
        System.out.println(mp.method(0.00001, 2147483647));
    }
}


class MyPow {

    public double method(double x, int n) {
        if (x < 1.0 && n > 1000000) {
            return 0.0;
        }
        if (x > 1.0 && n < -1000000) {
            return 0.0;
        }
        if (x == -1.0) {
            if (n % 2 == 0) { return 1.0; }
            else { return -1.0; }
        }

        if (n == 0) {
            return 1.0;
        }
        else if (n > 0) {
            return x * method(x, n - 1);
        }
        else {
            return 1.0 / method(x, -n);
        }
    }
}
