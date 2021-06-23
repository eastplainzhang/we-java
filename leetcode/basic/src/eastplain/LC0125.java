package eastplain;

/**
 * @author EastPlain
 * @create 2021-3-31 18:10
 */

public class LC0125 {

    public static void main(String[] args) {
        System.out.println(new IsPalindrome().method(""));
    }
}


class IsPalindrome {

    public boolean method(String s) {

        String original_s = s.trim().toLowerCase();
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < original_s.length(); i++) {
            if (('0' <= original_s.charAt(i) && original_s.charAt(i) <= '9') || ('a' <= original_s.charAt(i) && original_s.charAt(i) <= 'z')) {
                builder.append(original_s.charAt(i));
            }
        }

        String new_s = builder.toString();
        System.out.println("new_s  " + new_s);

        for (int i = 0; i < new_s.length() / 2; i++) {
            if (new_s.charAt(i) != new_s.charAt(new_s.length() - 1- i)) {
                return false;
            }
        }

        return true;
    }
}
