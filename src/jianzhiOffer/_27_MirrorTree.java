package jianzhiOffer;

/**
 * 二叉树的镜像
 * 先前序遍历这棵树的每个节点，如果遍历到的节点有子节点，就交换它的
 * 两个子节点。当交换所有非叶子节点的左、右子节点之后，就得到了树的镜像
 */
public class _27_MirrorTree {
    public void Mirror(TreeNode root){
        if(root == null)
            return;
        swapTreeNode(root);
        Mirror(root.left);
        Mirror(root.right);

    }

    private void swapTreeNode(TreeNode root){
        TreeNode t = root.left;
        root.left = root.right;
        root.right = t;
    }

}
