package method;

import infrastructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树的层序遍历
 * # lc0102
 *
 * @author EastPlain
 * @date 2021/7/26 23:37
 */
public class BinaryTreeLayer {

    public List<List<Integer>> method(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if (root == null) {
            return ans;
        }

        queue.add(root);

        while (! queue.isEmpty()) {

            int size = queue.size();
            List<Integer> temp = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode current = queue.remove();
                temp.add(current.val);

                if (current.left != null) {
                    queue.add(current.left);
                }

                if (current.right != null) {
                    queue.add(current.right);
                }
            }

            ans.add(temp);
        }

        return ans;
    }
}
