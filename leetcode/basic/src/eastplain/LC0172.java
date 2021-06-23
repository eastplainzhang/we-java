package eastplain;

public class LC0172 {
}


class TrailingZerosTest {

    public int method(int n) {
        int count = 0;
        while (n > 0) {
            count += n / 5;
            n /= 5;
        }
        return count;
    }
}
