package method;

import infrastructure.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * N叉树的前序遍历
 * # lc0589
 *
 * @author EastPlain
 * @date 2021/7/27 22:37
 */
public class NTreePreorder {

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

        list.add(root.val);

        for (Node node : root.children) {
            helper(node, list);
        }
    }

    /**
     * 迭代法
     */
    public List<Integer> iteration(Node root) {

        List<Integer> ans = new ArrayList<>();
        Stack<Node> stack = new Stack<>();

        if (root == null) {
            return ans;
        }

        stack.push(root);

        while (! stack.isEmpty()) {

            Node current = stack.pop();
            ans.add(current.val);

            Stack<Node> temp = new Stack<>();

            for (Node node : current.children) {
                temp.push(node);
            }

            while (! temp.isEmpty()) {
                stack.push(temp.pop());
            }
        }

        return ans;
    }
}
