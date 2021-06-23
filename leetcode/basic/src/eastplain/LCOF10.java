package eastplain;

public class LCOF10 {

    public static void main(String[] args) {

        FibLarge fl = new FibLarge();
        System.out.println(fl.method(95));
    }
}


class FibLarge {

    public int method(int n) {

        int a = 0;
        int b = 1;
        int sum ;
        for (int i = 0; i < n; ++i) {
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;

    }
}
