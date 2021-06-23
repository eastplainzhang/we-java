package eastplain;

public class LC0053 {

    public static void main(String[] args) {
        int[] demo = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(new MaxSubArrayTest().method(demo));
    }
}


class MaxSubArrayTest {

    public int method(int[] nums) {

        int length = nums.length;
        int ans = nums[0];
        int temp = nums[0];

        for (int i = 1; i < length; i++) {
            temp = nums[i] + Math.max(temp, 0);
            ans = Math.max(ans, temp);
        }

        return ans;
    }
}