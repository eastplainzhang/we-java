package eastplain;

public class LC1662 {
}


class ArrayStringsAreEqual {

    public boolean method(String[] word1, String[] word2) {

        StringBuilder b1 = new StringBuilder();
        StringBuilder b2 = new StringBuilder();

        for (String s : word1) {
            for (int i = 0; i < s.length(); ++i) {
                b1.append(s.charAt(i));
            }
        }

        for (String s : word2) {
            for (int i = 0; i < s.length(); ++i) {
                b2.append(s.charAt(i));
            }
        }

        if (b1.length() != b2.length()) {
            return false;
        }

        for (int i = 0; i < b1.length(); ++i) {
            if (b1.charAt(i) != b2.charAt(i)) {
                return false;
            }
        }

        return true;
    }
}
