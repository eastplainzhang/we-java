package eastplain;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author EastPlain
 * @create 2021-4-07 10:04
 */

public class LCOF45 {

    public static void main(String[] args) {

        int[] dmeo = new int[]{10, 2, 9, 39, 17};
        System.out.println(new MinNumber().methodHeap(dmeo));
    }
}


class MinNumber {

    // 手写快排
    public String method(int[] nums) {

        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }

        quickSort(strs, 0, strs.length - 1);

        StringBuilder builder = new StringBuilder();
        for (String s : strs) {
            builder.append(s);
        }

        return builder.toString();
    }

    public void quickSort(String[] strs, int l, int r) {

        if (l >= r) return;

        int i = l;
        int j = r;
        String temp = strs[i];
        while (i < j) {
            while ((strs[j] + strs[l]).compareTo(strs[l] + strs[j]) >= 0 && i < j) { j -= 1; }
            while ((strs[i] + strs[l]).compareTo(strs[l] + strs[i]) <= 0 && i < j) { i += 1; }
            temp = strs[i];
            strs[i] = strs[j];
            strs[j] = temp;
        }

        strs[i] = strs[l];
        strs[l] = temp;
        quickSort(strs, l, i - 1);
        quickSort(strs, i + 1, r);
    }

    // Java内置排序
    public String methodInner (int[] nums) {

        String[] strs = new String[nums.length];

        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(strs, (x, y) -> (x + y).compareTo(y + x));

        StringBuilder builder = new StringBuilder();

        for (String s : strs) {
            builder.append(s);
        }

        return builder.toString();
    }

    // 构建堆
    public String methodHeap (int[] nums) {

        Queue<String> queue = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1 + o2).compareTo(o2 + o1);
            }
        });

        for (int num : nums) {
            queue.add("" + num);
        }
        System.out.println(queue);

        StringBuilder builder = new StringBuilder();

        while (!queue.isEmpty()) {
            builder.append(queue.poll());
        }

        return builder.toString();
    }

}
