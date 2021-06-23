package eastplain;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author EastPlain
 * @create 2021-4-01 11:42
 *
 * 二叉树的层序遍历
 * 从上到下打印二叉树 I
 * 从上到下打印二叉树 II
 * 从上到下打印二叉树 III
 */
public class LCOF32 {
}


class LevelOrderTree {

    public int[] method_1(TreeNode root) {

        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if (root == null) {
            return new int[]{};
        }

        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                TreeNode node = queue.remove();
                list.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }

        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); ++i) {
            ans[i] = list.get(i);
        }

        return ans;
    }

    public List<List<Integer>> method_2(TreeNode root) {

        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if (root == null) {
            return list;
        }

        queue.add(root);

        while(!queue.isEmpty()) {
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
