package eastplain;

public class LC1688 {

    public static void main(String[] args) {
        System.out.println(new NumberOfMatches().method(14));
    }
}


class NumberOfMatches {

    public int method(int n) {

        int count = 0;

        while (n > 1) {
            if (n % 2 == 0) {
                count += n / 2;
                n = n / 2;
            }
            else {
                count += n / 2;
                n = n / 2 + 1;
            }
        }

        return count;
    }
}
