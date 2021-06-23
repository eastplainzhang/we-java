package eastplain;

public class LC1732 {

    public static void main(String[] args) {
        System.out.println(new LargestAltitude().method(new int[]{-5, 1, 5, 0, -7}));
    }
}


class LargestAltitude {

    public int method(int[] gain) {

        int current = 0;
        int max = 0;

        for (int j : gain) {
            current += j;
            max = Math.max(max, current);
        }

        return max;
    }
}
