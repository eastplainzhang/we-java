package eastplain;

/**
 * @author EastPlain
 * @create 2021-4-13 17:31
 */
public class LC0112 {
}


class HasPathSum {

    // dfs
    public boolean hasPathSum(TreeNode root, int targetSum) {

        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }

        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }

}
