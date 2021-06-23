package eastplain;

/**
 * @author EastPlain
 * @create 2021-3-09 11:35
 */
public class LCOF05 {
}


class Solution {

    public String replaceSpace(String s) {
        int length = s.length();
        char[] array = new char[length * 3];
        int size = 0;
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                array[size] = '%';
                size += 1;
                array[size] = '2';
                size += 1;
                array[size] = '0';
                size += 1;
            }
            else {
                array[size] = c;
                size += 1;
            }
        }
        return new String(array, 0, size);
    }
}
