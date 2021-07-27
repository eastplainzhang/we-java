package method;

import infrastructure.TreeNode;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的中序遍历
 * # lc0094
 *
 * @author EastPlain
 * @date 2021/7/26 23:18
 */
public class BinaryTreeInorder {

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

        Stack<TreeNode> stack = new Stack<>();
        List<Integer> ans = new ArrayList<>();

        if (root == null) {
            return ans;
        }

        TreeNode current = root;

        while (! stack.isEmpty() || current != null) {

            while (current != null) {
                stack.push(current);
                current = current.left;
            }

           TreeNode node = stack.pop();
            ans.add(node.val);

            if (node.right != null) {
                stack.push(node.right);
            }
        }

        return ans;
    }
}


