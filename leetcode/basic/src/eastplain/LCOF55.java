package eastplain;

/**
 * @author EastPlain
 * @create 2021-4-01 14:30
 *
 * 平衡二叉树
 */
public class LCOF55 {
}


class IsBalanced {

    public boolean method_2(TreeNode root) {

        if (root == null) {
            return true;
        }

        return Math.abs(depth(root.left) - depth(root.right)) <= 1 && method_2(root.left) && method_2(root.right);
    }

    public int depth(TreeNode node) {

        if (node == null) {
            return 0;
        }

        return Math.max(depth(node.left), depth(node.right)) + 1;
    }
}
