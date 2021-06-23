package eastplain;

import java.util.Arrays;

/**
 * @author EastPlain
 * @create 2021-4-06 11:25
 */
public class LC0215 {
    public static void main(String[] args) {
        int[] demo = new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6};
        // System.out.println(new FindKthLargest().method_sort(demo, 4));
        System.out.println(new FindKthLargest().quick_sort(demo, 4));
    }
}


class FindKthLargest {

    // 调用Java自带的排序
    public int method_sort(int[] nums, int k) {
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        return nums[nums.length - k];
    }


    // 基于快排的思想
    public int quick_sort(int[] nums, int k) {

        k = nums.length - k;
        int first = 0;
        int last = nums.length - 1;

        while (first <= last) {
            int splitIndex = partition(nums, first, last);

            if (k < splitIndex) {
                last = splitIndex - 1;
            }
            else if (k > splitIndex) {
                first = splitIndex + 1;
            }
            else {
                return nums[splitIndex];
            }
        }
        return -1;
    }

    public int partition(int[] arr, int first, int last) {

        int value = arr[first];
        int left = first + 1;
        int right = last;
        boolean done = false;

        while (!done) {

            while (left <= right && arr[left] <= value) {
                left += 1;
            }
            while (left <= right && arr[right] >= value) {
                right -= 1;
            }

            if (left > right) {
                done = true;
            }
            else {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }

        arr[first] = arr[right];
        arr[right] = value;

        return right;
    }


    // 基于堆排序的思想
    // TODO: 2021/4/6
}
