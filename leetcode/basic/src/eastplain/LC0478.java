package eastplain;

import java.util.Arrays;

public class LC0478 {

    public static void main(String[] args) {
        RandPoint r1 = new RandPoint();
        r1.radius = 2;
        r1.x_center = 0;
        r1.y_center = 0;
        System.out.println(Arrays.toString(r1.method()));
    }
}


class RandPoint {

    double radius;
    double x_center;
    double y_center;

    public double[] method() {
        double[] ans = new double[2];
        while(true) {
            double x = Math.random() * 2 * radius + (x_center - radius);
            double y = Math.random() * 2 * radius + (y_center - radius);
            if(Math.pow((x - x_center), 2) + Math.pow((y - y_center), 2) <= Math.pow((radius), 2)) {
                ans[0] = x;
                ans[1] = y;
                return ans;
            }
        }
    }
}