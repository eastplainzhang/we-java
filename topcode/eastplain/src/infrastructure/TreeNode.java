package infrastructure;

/**
 * 定义 二叉树的结构
 *
 * @author EastPlain
 * @date 2021/7/26 21:52
 */
public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
