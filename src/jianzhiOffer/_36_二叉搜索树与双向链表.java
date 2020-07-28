package jianzhiOffer;

/**
 * 输入一棵二叉搜索树，
 * 将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class _36_二叉搜索树与双向链表 {
    private TreeNode pre = null;
    private TreeNode head = null;

    public TreeNode Convert(TreeNode root){
        inOrder(root);
        return head;
    }
    //中序遍历就是从小到到大的顺序
    private void inOrder(TreeNode node){
        if(node == null){
            return;
        }
        //直接递归到最左叶子节点
        inOrder(node.left);
        //直接把当前节点指向双向链表里面的前一个节点
        node.left = pre;
        if(pre != null)
            pre.right = node;
        pre = node;
        if(head == null)
            head = node;
        inOrder(node.right);


    }
}
