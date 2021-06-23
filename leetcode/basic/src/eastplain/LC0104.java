package eastplain;

/**
 * @author EastPlain
 * @create 2021-3-31 20:40
 */
public class LC0104 {
}


class MaxDepth {

    public int method(TreeNode root) {

        if (root == null) {
            return 0;
        }

        return Math.max(method(root.left), method(root.right)) + 1;

    }
}
