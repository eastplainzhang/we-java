package eastplain;

import java.util.Arrays;

/**
 * @author EastPlain
 * @create 2021-4-01 17:29
 */
public class LC1491 {
}


class Average {

    public double method(int[] salary) {

        Arrays.sort(salary);
        double sum = 0;
        for (int i = 1; i < salary.length - 1; ++i) {
            sum += salary[i];
        }

        return sum / (salary.length - 2);
    }
}
