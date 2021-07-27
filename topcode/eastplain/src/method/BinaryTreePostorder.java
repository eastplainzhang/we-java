package method;

import infrastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的后序遍历
 * # lc0145
 *
 * @author EastPlain
 * @date 2021/7/27 23:28
 */
public class BinaryTreePostorder {

    /**
     * 递归法
     */
    public List<Integer> recur(TreeNode root) {

        return null;
    }

    /**
     * 迭代法
     */
    public List<Integer> iteration(TreeNode root) {

        List<Integer> ans = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> stack_out = new Stack<>();

        if (root == null) {
            return ans;
        }

        stack.push(root);

        while(! stack.isEmpty()) {

            TreeNode current = stack.pop();
            stack_out.push(current);

            if (current.left != null) {
                stack.push(current.left);
            }

            if (current.right != null) {
                stack.push(current.right);
            }
        }

        while (! stack_out.isEmpty()) {
            TreeNode current = stack_out.pop();
            ans.add(current.val);
        }

        return ans;
    }

}
