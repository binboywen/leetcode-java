package jianzhiOffer;

/**
 * 判断一棵树是否是平衡二叉树
 */
public class _55_2_判断是否是平衡二叉树 {
    private boolean isBlanced = true;
    public boolean IsBalances(TreeNode root){
        height(root);
        return isBlanced;
    }
    private int height(TreeNode root){
        if(root == null || !isBlanced){
            return 0;
        }
        int left = height(root.left);
        int right = height(root.right);
        if(Math.abs(left - right) > 1)
            isBlanced = false;
        return 1 + Math.max(left, right);
    }
}
