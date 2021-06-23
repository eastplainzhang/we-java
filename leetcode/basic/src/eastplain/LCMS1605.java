package eastplain;


/**
 * 20201126
 * LCMS1605
 * Time     97
 * Storage  77
 */

public class LCMS1605 {

    public static void main(String[] args) {

        TrailingZeros t1 = new TrailingZeros();
        System.out.println(t1.method(30));
    }
}


class TrailingZeros {

    public int method(int n) {
        int count = 0;
        while(n >= 5) {
            n /= 5;
            count += n;
        }
        return count;
    }

}
