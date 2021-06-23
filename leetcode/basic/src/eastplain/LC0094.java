package eastplain;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author EastPlain
 * @create 2021-3-01 10:01
 *
 * 二叉树的中序遍历
 */
public class LC0094 {
}


class InorderTraversal {

    // 递归法
    public List<Integer> method_recursion(TreeNode root) {

        List<Integer> list = new ArrayList<>();
        helper(root, list);
        return list;

    }

    public void helper(TreeNode root, List<Integer> store) {

        if (root == null) {
            return;
        }

        helper(root.left, store);
        store.add(root.val);
        helper(root.right, store);
    }

    // 迭代法
    public List<Integer> method_iteration(TreeNode root) {

        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        if (root == null) {
            return list;
        }

        TreeNode current = root;

        while (!stack.isEmpty() || current != null) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            TreeNode node = stack.pop();
            list.add(node.val);
            if (node.right != null) {
                current = node.right;
            }
        }

        return list;
    }

}
