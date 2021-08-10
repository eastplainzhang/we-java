package base.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author EastPlain
 * @date 2021/7/28 12:35
 */
public class QuickSort {

    public int[] method(int[] arr) {
        helper(arr, 0, arr.length - 1);
        return arr;
    }

    public void helper(int[] arr, int first, int last) {

        if (first < last) {
            int splitPoint = partition(arr, first, last);
            helper(arr, first, splitPoint - 1);
            helper(arr, splitPoint + 1, last);
        }
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

    @Test
    public void sortTest() {
        int[] demo = new int[]{53, 636, 64, 8, 3, 6, 23, 256, 231, 1, 7, 15, 123};
        System.out.println(Arrays.toString(method(demo)));
    }
}

