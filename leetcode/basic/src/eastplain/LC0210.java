package eastplain;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author EastPlain
 * @create 2021-4-13 17:55
 */
public class LC0210 {
}


class FindOrder {

    public boolean findOrder(int numCourses, int[][] prerequisites) {

        if (numCourses <= 0) {
            return false;
        }

        int[] inDegrees = new int[numCourses];

        for (int[] p : prerequisites) {
            inDegrees[p[0]] += 1;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < inDegrees.length; ++i) {
            if (inDegrees[i] == 0) {
                queue.add(i);
            }
        }

        int count = 0;
        int[] res = new int[numCourses];

        while (!queue.isEmpty()) {
            int current = queue.poll();
            res[count] = current;
            count += 1;
            for (int[] p : prerequisites) {
                if (p[1] == current) {
                    inDegrees[p[0]] -= 1;
                    if (inDegrees[p[0]] == 0) {
                        queue.add(p[0]);
                    }
                }
            }
        }

        return count == numCourses;
    }
}
