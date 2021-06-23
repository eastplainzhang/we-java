package eastplain;

public class LCMS0103 {

    public static void main(String[] args) {
        System.out.println(new ReplaceSpace().method("Mr John Smith    ", 13));
    }
}


class ReplaceSpace {

    public String method(String s, int length) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < length; ++i) {
            if (s.charAt(i) == ' ') {
                builder.append("%20");
            }
            else {
                builder.append(s.charAt(i));
            }
        }
        return builder.toString();
    }
}
