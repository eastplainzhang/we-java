package eastplain;

public class LCP017 {

    public static void main(String[] args) {
        System.out.println(new Calculate().method("AB"));
    }
}


class Calculate {

    public int method(String s) {

        int x = 1;
        int y = 0;

        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == 'A') {
                x = 2 * x + y;
            }
            else {
                y = 2 * y + x;
            }
        }

        return x + y;
    }
}