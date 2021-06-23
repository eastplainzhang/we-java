package eastplain;

/**
 * @author EastPlain
 * @create 2021-4-06 17:30
 */
public class LC1710 {

    public static void main(String[] args) {
        int[][] demo = new int[][]{{1, 3}, {5, 5}, {2, 5}, {4, 2}, {4, 1}, {3, 1}, {2, 2}, {1, 3}, {2, 5}, {3, 2}};
        System.out.println(new MaximumUnits().method(demo, 35));
    }
}


class MaximumUnits {

    public int method(int[][] boxTypes, int truckSize) {

        int[] temp = new int[10];

        for (int[] box : boxTypes) {
            temp[box[1]] += box[0];
        }
        // System.out.println(Arrays.toString(temp));

        int count = 0;
        int ans = 0;
        for (int i = temp.length - 1; i >= 0; --i) {
            int realNum = Math.min(temp[i], (truckSize - count));
            count += realNum;
            ans += i * realNum;
            if (count >= truckSize) {
                break;
            }
        }
        return ans;
    }
}
