package jianzhiOffer;

/**
 * 树中两个节点的最低公共祖先

 */
public class _68_lowestCommonAncestor {
    /**
     * 二叉查找树中，两个节点 p, q 的公共祖先 root
     * 满足 root.val >= p.val && root.val <= q.val。
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return root;
        if (root.val > p.val && root.val > q.val)
            return lowestCommonAncestor(root.left, p, q);
        if (root.val < p.val && root.val < q.val)
            return lowestCommonAncestor(root.right, p, q);
        return root;
    }
    /**
     * 普通二叉树
     * 在左右子树中查找是否存在 p 或者 q，
     * 如果 p 和 q 分别在两个子树中，
     * 那么就说明根节点就是最低公共祖先。
     */

    public TreeNode lowestCommonAncestor_1(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q)
            return root;
        TreeNode left = lowestCommonAncestor_1(root.left, p, q);
        TreeNode right = lowestCommonAncestor_1(root.right, p, q);
        return left == null ? right : right == null ? left : root;
    }
}
