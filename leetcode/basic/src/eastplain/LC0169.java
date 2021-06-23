package eastplain;

/**
 * @author EastPlain
 * @create 2021-4-06 10:38
 */
public class LC0169 {

    public static void main(String[] args) {
        int[] demo = new int[]{6, 5, 5};
        System.out.println(new MajorityElement().method(demo));
    }
}


class MajorityElement {

    // 摩尔投票法
    public int method(int[] nums) {

        int count = 0;
        Integer temp = null;

        for (int num : nums) {
            if (count == 0) {
                temp = num;
            }

            if (num == temp) {
                count += 1;
            }
            else {
                count -= 1;
            }
        }

        return temp;
    }
}
