package method;

import infrastructure.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * N叉树的层序遍历
 * # lc0429
 *
 * @author EastPlain
 * @date 2021/7/27 23:15
 */
public class NTreeLayer {

    public List<List<Integer>> method(Node root) {

        List<List<Integer>> ans = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();

        if (root == null) {
            return ans;
        }

        queue.add(root);

        while (! queue.isEmpty()) {

            int size = queue.size();
            List<Integer> temp = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                Node current = queue.remove();
                temp.add(current.val);
                queue.addAll(current.children);
            }

            ans.add(temp);
        }

        return ans;
    }
}
