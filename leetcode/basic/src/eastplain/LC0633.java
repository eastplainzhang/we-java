package eastplain;

/**
 * @author EastPlain
 * @create 2021-4-28 16:46
 */
public class LC0633 {

    public static void main(String[] args) {
        System.out.println(new JudgeSquareSum().method(5));
    }
}


class JudgeSquareSum {

    public boolean method(int c) {

        int l = 0;
        int r = (int) Math.sqrt(c) + 1;

        while (l <= r) {
            int sum = (int) (Math.pow(l, 2) + Math.pow(r, 2));
            if (sum < c) {
                l += 1;
            }
            else if (sum > c) {
                r -= 1;
            }
            else {
                return true;
            }
        }

        return false;
    }
}
