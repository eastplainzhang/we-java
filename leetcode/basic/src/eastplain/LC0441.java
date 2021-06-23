package eastplain;

public class LC0441 {

    public static void main(String[] args) {
        System.out.println(new ArrangeCoins().method(1804289383));
    }
}


class ArrangeCoins {

    public int method(int n) {

        int line = 1;

        while (n >= line * (line + 1) / 2) {
            line += 1;
        }

        return line - 1;
    }
}
