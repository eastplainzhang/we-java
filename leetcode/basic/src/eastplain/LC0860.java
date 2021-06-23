package eastplain;

/**
 * LC0860
 * 20201210
 * Time     100
 * Storage  58
 */
public class LC0860 {

    public static void main(String[] args) {
        LemonadeChange l = new LemonadeChange();
        int[] demo = new int[]{5, 5, 10, 10, 20};
        System.out.println(l.method(demo));
    }
}


class LemonadeChange {

    public boolean method(int[] bills) {

        int count_5 = 0;
        int count_10 = 0;
        for (int bill : bills) {
            if (bill == 5) {
                count_5 += 1;
            }
            else if (bill == 10) {
                count_10 += 1;
                if (count_5 > 0) {
                    count_5 -= 1;
                }
                else {
                    return false;
                }
            }
            else {
                if (count_10 > 0 && count_5 > 0) {
                    count_10 -= 1;
                    count_5 -= 1;
                }
                else if (count_5 > 2) {
                    count_5 -= 3;
                }
                else {
                    return false;
                }
            }
            System.out.println("count_5: " + count_5);
            System.out.println("count_10: " + count_10);
        }
        return true;
    }
}
