package eastplain;

import java.util.Arrays;

/**
 * @author EastPlain
 * @create 2021-4-07 17:14
 */
public class LC0088 {

    public static void main(String[] args) {

        int[] n1 = new int[]{4, 5, 6, 0, 0, 0};
        int[] n2 = new int[]{1, 2, 3};
        new MergeNums().merge_point(n1, 3, n2, 3);
    }
}


class MergeNums {

    /*
    复制之后排序
    Time     0
    Storage  85
     */
    public void merge_copy(int[] nums1, int m, int[] nums2, int n) {

        int[] temp = new int[m + n];
        System.arraycopy(nums1, 0, temp, 0, m);
        System.arraycopy(nums2, 0, temp, m, n);
        Arrays.sort(temp);
        System.arraycopy(temp, 0, nums1, 0, m + n);

    }

    /*
    逆向双指针
    Time     100
    Storage  98
     */
    public void merge_point(int[] nums1, int m, int[] nums2, int n) {

        int p1 = m - 1;
        int p2 = n - 1;
        int i = m + n - 1;

        while (i >= 0) {

            if (p1 >= 0 && p2 >= 0) {
                if (nums1[p1] >= nums2[p2]) {
                    nums1[i] = nums1[p1];
                    p1 -= 1;
                    i -= 1;
                }
                else {
                    nums1[i] = nums2[p2];
                    p2 -= 1;
                    i -= 1;
                }
            }
            else if (p2 >= 0) {
                nums1[i] = nums2[p2];
                p2 -= 1;
                i -= 1;
            }
            else {
                break;
            }
        }

        System.out.println(Arrays.toString(nums1));
    }
}
