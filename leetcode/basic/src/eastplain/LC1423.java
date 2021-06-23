package eastplain;

public class LC1423 {

    public static void main(String[] args) {
        int[] demo = new int[]{1, 2, 3, 4, 5, 6, 1};
        System.out.println(new MaxScore().maxScore(demo, 3));
    }
}


class MaxScore {

    /**
     * 递归超时
     */
    // TODO
    public int maxScore(int[] cardPoints, int k) {

        return dp(cardPoints, 0, cardPoints.length - 1, k);
    }


    public int dp(int[] nums, int left, int right, int k) {

        if (right - left <= nums.length - k) {
            return Math.max(nums[left], nums[right]);
        }

        else return Math.max(nums[left] + dp(nums, left + 1, right, k), nums[right] + dp(nums, left, right - 1, k));
    }

}