package eastplain;

import java.util.ArrayList;
import java.util.List;

/**
 * @author EastPlain
 * @create 2021-3-31 19:34
 */
public class LC0412 {

    public static void main(String[] args) {
        System.out.println(new FizzBuzz().method(15));
    }
}


class FizzBuzz {

    public List<String> method(int n) {

        List<String> ans = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                ans.add("FizzBuzz");
            }
            else if (i % 3 == 0) {
                ans.add("Fizz");
            }
            else if (i % 5 == 0) {
                ans.add("Buzz");
            }
            else {
                ans.add(String.valueOf(i));
            }
        }

        return ans;
    }
}