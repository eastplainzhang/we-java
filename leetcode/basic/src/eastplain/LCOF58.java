package eastplain;

public class LCOF58 {

    public static void main(String[] args) {
        ReverseLeftWords r = new ReverseLeftWords();
        String demo = new String("wwwoooiii");
        System.out.println(r.method(demo, 3));
    }

}


class ReverseLeftWords {

    public String method(String s, int n) {
        char[] c = s.toCharArray();
        int length = c.length;
        char[] new_c = new char[length];

        for (int i = 0; i < length - n; ++i) {
            new_c[i] = c[i + n];
        }

        for (int i = length - n; i < length; ++i) {
            new_c[i] = c[i - (length - n)];
        }

        String new_s = String.valueOf(new_c);

        return new_s;
    }
}
