package eastplain;

/**
 * @author EastPlain
 * @date 2021/7/12 23:03
 */
public class LCOF26 {
}


class IsSubStructure {

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return (A != null && B != null) && (recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }


    boolean recur(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }
        if (A == null || A.val != B.val) {
            return false;
        }

        return recur(A.left, B.left) && recur(A.right, B.right);
    }
}
