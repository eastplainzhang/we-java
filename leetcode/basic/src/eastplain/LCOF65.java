package eastplain;

/**
 * @author EastPlain
 * @create 2021-4-07 16:44
 */
public class LCOF65 {

    public static void main(String[] args) {
        System.out.println(new Add().method(3, 4));
    }
}


class Add {

    public int method(int a, int b) {
        if (a == 0 || b == 0) {
            return a ^ b;
        }
        return method(a ^ b, (a & b) << 1);
    }
}