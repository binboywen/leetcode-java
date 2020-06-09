package jianzhiOffer;

/**
 * 实现一个函数，用来判断一颗二叉树是不是对称的。如果一颗二叉树和它的镜像一样
 * 那么他是对称的。
 * 我们可以通过比较二叉树的前序遍历序列和对称前序遍历序列（根、右、左）
 * 来判断二叉树是不是对称的。
 * 如果两个序列是一样的，那么二叉树就是对称的。
 */
public class _28_isSymmetricTree {
    public boolean isSymmetric(TreeNode root){
        return isSymmetric(root.left,root.right);
    }
    private boolean isSymmetric(TreeNode left, TreeNode right){
        if(left == null && right == null){
            return true;
        }
        if(left == null || right == null){
            return false;
        }
        if(left.val != right.val){
            return false;
        }

        return isSymmetric(left.left, right.right) &&
                isSymmetric(left.right, right.left);
    }

}
