package eastplain;

import java.util.HashMap;
import java.util.Map;

public class LCOF50 {

    public static void main(String[] args) {
        System.out.println(new FirstUniqChar().firstUniqChar("abaccdeff"));
    }
}


class FirstUniqChar {

    public char firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();

        char[] c = s.toCharArray();

        for (char c1 : c) {
            map.put(c1, map.getOrDefault(c1, 0) + 1);
        }

        for (char c1 : c) {
            if (map.get(c1) == 1) {
                return c1;
            }
        }

        return ' ';
    }
}
