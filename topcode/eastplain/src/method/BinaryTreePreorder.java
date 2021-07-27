package method;



import infrastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的前序遍历
 * # lc0144
 *
 * @author EastPlain
 * @date 2021/7/26 22:06
 */
public class BinaryTreePreorder {

    /**
     * 递归法
     */
    public void recur(TreeNode root) {

        List<Integer> list = new ArrayList<>();

        helper(root, list);

        System.out.println(list);
    }

    public void helper(TreeNode root, List<Integer> list) {

        if (root == null) {
            return;
        }

        list.add(root.val);

        helper(root.left, list);

        helper(root.right, list);
    }

    /**
     * 迭代法
     */
    public void iteration(TreeNode root) {

        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();

        if (root == null) {
            return;
        }

        stack.push(root);

        while (! stack.isEmpty()) {

            TreeNode current = stack.pop();

            list.add(current.val);

            if (current.right != null) {
                stack.push(current.right);
            }

            if (current.left != null) {
                stack.push(current.left);
            }
        }

        System.out.println(list);

    }
}

