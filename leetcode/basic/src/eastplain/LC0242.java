package eastplain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author EastPlain
 * @create 2021-4-06 18:33
 */
public class LC0242 {

    public static void main(String[] args) {
        String s = "dog";
        String t = "cat";
        System.out.println(new IsAnagram().method_sort(s, t));
    }
}


class IsAnagram {

    /*
    hashmap
    Time     22
    Storage  23
     */
    public boolean method(String s, String t) {
        Map<Character, Integer> s_map = new HashMap<>();
        Map<Character, Integer> t_map = new HashMap<>();

        for (int i = 0; i < s.length(); ++i) {
            s_map.put(s.charAt(i), s_map.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (int i = 0; i < t.length(); ++i) {
            t_map.put(t.charAt(i), t_map.getOrDefault(t.charAt(i), 0) + 1);
        }

        if (s_map.size() != t_map.size()) {
            return false;
        }

        for (Character c : s_map.keySet()) {
            if (!s_map.get(c).equals(t_map.getOrDefault(c, 0))) {
                return false;
            }
        }

        return true;
    }

    /*
    sort
    Time     64
    Storage  76
     */
    public boolean method_sort(String s, String t) {
        char[] s_char = s.toCharArray();
        char[] t_char = t.toCharArray();
        Arrays.sort(s_char);
        Arrays.sort(t_char);
        return Arrays.equals(s_char, t_char);
    }
}
