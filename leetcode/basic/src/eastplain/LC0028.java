package eastplain;

/**
 * @author EastPlain
 * @create 2021-3-31 18:21
 */

public class LC0028 {

    public static void main(String[] args) {
        System.out.println(new StrStr().method("hello", "ll"));
    }
}


class StrStr {

    public int method(String haystack, String needle) {

        if (needle == null) {
            return 0;
        }

        if (haystack.length() < needle.length()) {
            return -1;
        }

        for (int i = 0; i < haystack.length() - needle.length() + 1; ++i) {
            boolean found = true;
            for (int j = 0; j < needle.length(); ++j) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    found = false;
                    break;
                }
            }
            if (found) {
                return i;
            }
        }

        return -1;
    }
}
