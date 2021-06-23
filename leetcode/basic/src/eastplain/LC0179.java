package eastplain;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author EastPlain
 * @create 2021-4-07 11:14
 */

public class LC0179 {

    public static void main(String[] args) {

        int[] dmeo = new int[]{0, 0};
        System.out.println(new LargestNumber().heapMethod(dmeo));
    }
}


class LargestNumber {

    public String heapMethod(int[] nums) {

        Queue<String> queue = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2);
            }
        });

        for (int num : nums) {
            queue.add("" + num);
        }
        System.out.println(queue);

        assert queue.peek() != null;
        if (queue.peek().equals("0")) {
            return "0";
        }

        StringBuilder builder = new StringBuilder();

        while (!queue.isEmpty()) {
            builder.append(queue.poll());
        }

        return builder.toString();
    }
}
