package eastplain;

import java.util.HashMap;
import java.util.Map;

/**
 * @author EastPlain
 * @create 2021-3-31 17:46
 */

public class LC0387 {

    public static void main(String[] args) {
        System.out.println(new FirstUniqChar().method("leetcode"));
    }
}


class FirstUniqChar {

    public int method(String s) {

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); ++i) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            }
            else {
                map.put(s.charAt(i), 1);
            }
        }

        for (int i = 0; i < s.length(); ++i) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }

        return -1;
    }
}
