package eastplain;

/**
 * @author EastPlain
 * @create 2021-4-06 16:37
 */

public class LC0111 {
}


class MinDepth {

    public int method(TreeNode root) {

        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        int min_depth = Integer.MAX_VALUE;

        if (root.left != null) {
            min_depth = Math.min(method(root.left), min_depth);
        }

        if (root.right != null) {
            min_depth = Math.min(method(root.right), min_depth);
        }

        return min_depth + 1;
    }
}
