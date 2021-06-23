package eastplain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author EastPlain
 * @create 2021-4-28 17:21
 */
public class LC0003 {

    public static void main(String[] args) {
        System.out.println(new LengthOfLongestSubString().method("nancy"));
    }
}


class LengthOfLongestSubString {

    public int method(String s) {

        Map<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        int[] lengths = new int[chars.length];

        int head = 0;
        int tail = 0;
        int length = 0;
        int maxLength = 0;

        for (int i = 0; i < chars.length; i++) {
            if (map.containsKey(chars[i])) {
                head = Math.max(head, map.get(chars[i]) + 1);
            }
            map.put(chars[i], i);
            tail += 1;
            lengths[i] = tail - head;
            maxLength = Math.max(maxLength, lengths[i]);
        }

        System.out.println(Arrays.toString(lengths));
        return maxLength;
    }
}
