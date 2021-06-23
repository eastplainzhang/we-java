package eastplain;

/**
 * @author EastPlain
 * @create 2021-3-31 18:33
 */

public class LC0014 {

    public static void main(String[] args) {
        String[] demo = new String[]{"ab", "a"};
        System.out.println(new LongestCommonPrefix().method(demo));
    }
}


class LongestCommonPrefix {

    public String method(String[] strs) {

       if (strs == null || strs.length == 0) {
           return "";
       }

       int length = strs[0].length();
       int coutn = strs.length;

       for (int i = 0; i < length; ++i) {
           char c = strs[0].charAt(i);
           for (int j = 1; j < coutn; ++j) {
               if (i == strs[j].length() || strs[j].charAt(i) != c) {
                   return strs[0].substring(0, i);
               }
           }
       }
       return strs[0];
    }
}
