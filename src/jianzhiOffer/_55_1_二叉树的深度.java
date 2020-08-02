package jianzhiOffer;

/**
 * 二叉树的深度
 * 从根节点到叶子节点一次经过的节点(含根、叶节点)形成树的一条路径，最长路径的长度为树的深度
 */
public class _55_1_二叉树的深度 {
    public int TreeDepth(TreeNode root)
    {
        return root == null ? 0 : 1 + Math.max(TreeDepth(root.left),TreeDepth(root.right));
    }
}
