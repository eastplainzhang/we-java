package eastplain;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author EastPlain
 * @create 2021-4-01 10:57
 *
 * 二叉树的后序遍历
 */
public class LC0145 {
}


class PostorderTraversal {

    public List<Integer> method_recursion(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        helper(root, list);
        return list;
    }

    public void helper(TreeNode node, List<Integer> store) {
        if (node == null) {
            return;
        }
        helper(node.left, store);
        helper(node.right, store);
        store.add(node.val);
    }

    public List<Integer> method_iteration(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> stack_out = new Stack<>();

        if (root == null) {
            return list;
        }

        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            stack_out.push(node);
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }

        while (!stack_out.isEmpty()) {
            TreeNode node = stack_out.pop();
            list.add(node.val);
        }

        return list;
    }
}
