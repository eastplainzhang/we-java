package eastplain;

/**
 * @author EastPlain
 * @create 2021-4-19 9:55
 */

public class LC0337 {

    public static void main(String[] args) {

    }
}


class Rob03 {

    /**
     * 刚开始想用层序遍历，发现不对，比如对于[2, 1, 3, null, 4]这种正确结果应该是7，层序遍历为6
     * 参考题解区，使用动态规划来做
     * https://leetcode-cn.com/problems/house-robber-iii/solution/san-chong-fang-fa-jie-jue-shu-xing-dong-tai-gui-hu/
     */
    public int rob(TreeNode root) {
        int[] result = dfs(root);
        return Math.max(result[0], result[1]);
    }

    public int[] dfs(TreeNode node) {
        if (node == null) {
            return new int[2];
        }

        int[] result = new int[2];

        int[] l = dfs(node.left);
        int[] r = dfs(node.right);

        result[0] = Math.max(l[0], l[1]) + Math.max(r[0], r[1]);
        result[1] = l[0] + r[0] + node.val;

        return result;
    }
}
