package eastplain;

/**
 * @author EastPlain
 * @create 2021-4-28 16:57
 */
public class LC0264 {

    public static void main(String[] args) {
        System.out.println(new NthUglyNumberTest().method(10));
    }
}


class NthUglyNumberTest {

    public int method(int n) {

        int[] arr = new int[n];
        arr[0] = 1;

        int point_2 = 0;
        int point_3 = 0;
        int point_5 = 0;

        for (int i = 1; i < arr.length; i++) {
            int temp_2 = 2 * arr[point_2];
            int temp_3 = 3 * arr[point_3];
            int temp_5 = 5 * arr[point_5];

            int temp_min = Math.min(temp_2, Math.min(temp_3, temp_5));
            arr[i] = temp_min;

            if (temp_min == temp_2) {
                point_2 += 1;
            }
            if (temp_min == temp_3) {
                point_3 += 1;
            }
            if (temp_min == temp_5) {
                point_5 += 1;
            }
        }

        // System.out.println(Arrays.toString(arr));
        return arr[n - 1];
    }
}
