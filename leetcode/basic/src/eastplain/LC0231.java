package eastplain;

public class LC0231 {

    public static void main(String[] args) {
        IsPowerOfTwo demo = new IsPowerOfTwo();
        System.out.println(demo.method(1));
    }
}


class IsPowerOfTwo {

    public boolean method(int n) {
        if (n <= 0) {
            return false;
        }
        while (n > 1) {
            if (n % 2 == 0) {
                n /= 2;
            }
            else {
                return false;
            }
        }
        return true;
    }
}
