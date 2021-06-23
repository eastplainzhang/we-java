package eastplain;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author EastPlain
 * @create 2021-4-01 11:32
 */
public class LC0102 {
}


class LevelOrder {

    public List<List<Integer>> method(TreeNode root) {

        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if (root == null) {
            return list;
        }

        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < size; ++i) {
                TreeNode node = queue.remove();
                temp.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            list.add(temp);
        }

        return list;
    }
}
