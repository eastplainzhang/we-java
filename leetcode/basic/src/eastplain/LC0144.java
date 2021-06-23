package eastplain;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author EastPlain
 * @create 2021-4-01 10:39
 *
 * 二叉树的前序遍历
 */
public class LC0144 {
}


class PreorderTraversal {

    public List<Integer> method_recursion(TreeNode root) {

        List<Integer> list = new ArrayList<>();
        helper(root, list);
        return list;
    }

    public void helper(TreeNode node, List<Integer> store) {
        if (node == null) {
            return;
        }
        store.add(node.val);
        helper(node.left, store);
        helper(node.right, store);
    }

    public List<Integer> method_iteration(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        if (root == null) {
            return list;
        }

        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            list.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }

        return list;
    }
}
