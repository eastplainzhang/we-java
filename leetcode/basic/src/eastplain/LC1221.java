package eastplain;

public class LC1221 {

    public static void main(String[] args) {
        System.out.println(new BalancedStringSplit().method("LLLLRRRR"));
    }
}


class BalancedStringSplit {

    public int method(String s) {

        int count_l = 0;
        int count_r = 0;
        int count_balance = 0;

        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == 'L') {
                count_l += 1;
            }
            else {
                count_r += 1;
            }
            if (count_l > 0 && count_l == count_r) {
                count_balance += 1;
                count_l = 0;
                count_r = 0;
            }
        }

        return count_balance;
    }
}
