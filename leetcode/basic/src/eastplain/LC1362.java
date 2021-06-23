package eastplain;

import java.util.Arrays;

/**
 * 202011128
 * LC1362
 * Time     100
 * Storage  70
 */

public class LC1362 {

    public static void main(String[] args) {

        CloseDivisors c1 = new CloseDivisors();
        System.out.println(Arrays.toString(c1.method(1)));
    }
}


class CloseDivisors {

    public int[] method(int num) {
        int[] ans = new int[2];
        int start = (int) Math.sqrt(num);
        for(int i = start + 1; i >= 1; --i){
            int j = (num / i) + 1;
            if(i * j == num + 1 || i * j == num + 2) {
                ans[0] = i;
                ans[1] = j;
                break;
            }
        }
        return ans;
    }
}
