package jianzhiOffer;

/**
 * 二叉查找树的第K个节点
 * 给定一棵二叉搜索树，请找出其中第k大的节点。
 * 中序遍历就是按照递增排序的。
 */
public class _54_KthNodeOfBinarySerachTree {
    private TreeNode ret;
    private int cnt = 0;

    public TreeNode KthNode(TreeNode root, int k){
        inOrder(root,k);
        return ret;
    }
    private void inOrder(TreeNode root, int k){
        if(root == null || cnt >= k)
            return;
        inOrder(root.left,k);
        cnt++;
        if(cnt == k)
            ret = root;
        inOrder(root.right,k);
    }
}

