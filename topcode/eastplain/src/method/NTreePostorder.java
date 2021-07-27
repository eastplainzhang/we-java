package method;

import infrastructure.Node;

import java.util.*;

/**
 * N叉树的后序遍历
 * # lc0590
 *
 * @author EastPlain
 * @date 2021/7/27 22:58
 */
public class NTreePostorder {

    /**
     * 递归法
     */
    public List<Integer> recur(Node root) {

        List<Integer> ans = new ArrayList<>();

        helper(root, ans);

        return ans;
    }

    public void helper(Node root, List<Integer> list) {

        if (root == null) {
            return;
        }

        for (Node node : root.children) {
            helper(node, list);
        }

        list.add(root.val);
    }

    /**
     * 迭代法
     */
    public List<Integer> iteration(Node root) {

        List<Integer> ans = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        Stack<Node> stack_out = new Stack<>();

        if (root == null) {
            return ans;
        }

        stack.push(root);

        while (! stack.isEmpty()) {
            Node current = stack.pop();
            stack_out.push(current);

            for (Node node : current.children) {
                stack.push(node);
            }
        }

        while (! stack_out.isEmpty()) {
            Node node = stack_out.pop();
            ans.add(node.val);
        }

        return ans;
    }
}
