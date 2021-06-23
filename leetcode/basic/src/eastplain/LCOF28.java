package eastplain;

/**
 * @author EastPlain
 * @create 2021-4-01 14:41
 */
public class LCOF28 {
}


class IsSymmetric {

    public boolean method(TreeNode root) {

        if (root == null) {
            return true;
        }

        return helper(root.left, root.right);

    }

    boolean helper(TreeNode l, TreeNode r) {
        if (l == null && r == null) {
            return true;
        }

        if (l == null || r == null || l.val != r.val) {
            return false;
        }

        return helper(l.left, r.right) && helper(r.left, l.right);
    }

}
