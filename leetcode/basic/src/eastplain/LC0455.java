package eastplain;

import java.util.Arrays;

public class LC0455 {

    public static void main(String[] args) {
        int[] g = new int[]{1, 2, 3};
        int[] s = new int[]{1, 1};
        System.out.println(new FindContentChildren().findContentChildren(g, s));
    }
}

class FindContentChildren {

    public int findContentChildren(int[] g, int[] s) {

        Arrays.sort(g);
        Arrays.sort(s);

        int g_point = 0;
        int s_point = 0;
        int count = 0;

        while (g_point < g.length && s_point < s.length) {
            if (s[s_point] >= g[g_point]) {
                count += 1;
                g_point += 1;
            }
            s_point += 1;
        }

        return count;
    }
}
