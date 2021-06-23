package eastplain;

import java.util.LinkedList;
import java.util.List;

/**
 * @author EastPlain
 * @create 2021-4-07 14:50
 */
public class LC0034 {
}


class PathSum {

    LinkedList<List<Integer>> ans = new LinkedList<>();
    LinkedList<Integer> tempPath = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        recur(root, target);
        return ans;
    }

    public void recur(TreeNode node, int target) {

        if (node == null) {
            return;
        }

        tempPath.add(node.val);
        target -= node.val;

        if (target == 0 && node.left == null && node.right == null) {
            ans.add(new LinkedList<>(tempPath));
        }

        recur(node.left, target);
        recur(node.right, target);

        tempPath.removeLast();
    }
}
