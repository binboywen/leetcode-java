package jianzhiOffer;

import sun.reflect.generics.tree.Tree;

/**
 * 输入两颗二叉树A和B，判断B是不是A的子结构
 * 第一步，在数树A中找到和树B的根节点的值一样的节点R
 * 第二步，判断树A中以R为根节点的子树是不是包含和树B一样的结构
 */
public class _26_树的子结构 {
    public boolean HasSubTree(TreeNode root1, TreeNode root2){
        if(root1 == null || root2 == null)
            return false;
        return isSubTreeWithRoot(root1, root2) || HasSubTree(root1.left,root2)||
                HasSubTree(root1.right, root2);
    }

    private boolean isSubTreeWithRoot(TreeNode root1, TreeNode root2){
        if(root2 == null)
            return true;
        if(root1 == null)
            return false;
        if(root1.val != root2.val)
            return false;
        return isSubTreeWithRoot(root1.left, root2.left) && isSubTreeWithRoot(root1.right, root2.right);

    }
}
