package jianzhiOffer;

import java.util.HashMap;
import java.util.Map;

/**
 * 根据二叉树的前序遍历和中序遍历的结果，重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 */
public class _07_重建二叉树 {
    /**
     * 前序中序建立二叉树
     */
    public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre == null || in == null || pre.length != in.length || pre.length < 1) {
            return null;
        }
        //调用递归
        TreeNode root = reConstructBinaryTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
        return root;
    }

    private static TreeNode reConstructBinaryTree(int[] pre, int startPre, int endPre, int[] in, int startIn, int endIn) {
        if (startPre > endPre || startIn > endIn) {
            return null;
        }
        //根节点为前序数组的第一个元素
        TreeNode root = new TreeNode(pre[startPre]);
        for (int i = 0; i <= endIn; i++) {
            //根据前序遍历得到的根结点在中序遍历中查找根结点的下标i
            if (pre[startPre] == in[i]) {
                /*
                 * 接着进行递归，因为得到中序的根节点后，中序数组根节点左边的元素为左子树，右边的元素为右子树
                 * 计算左右子树的起始和结束下标，然后继续进行递归
                 * */
                /*计算左树子节点其实结束下标
                 * 前序起始位置startPre = 原来的前序的startPre后移一位，也就是 startPre = startPre + 1
                 * 前序结束下标endPre = 前序起始位置 + 左子树元素的长度，左子树长度=查出的中序根节点下标值减去中序的初始下标，
                 * 也就是左子树长度 = i - startIn,综合起来就是前序结束下标 enPre = startPre + i - startIn。
                 *
                 * 中序起始位置startIn = startIn ，保持不变
                 * 前序结束下标endIn = 查出来的中序根节点下标值 - 1，即endIn = i-1。
                 * */
                root.left = reConstructBinaryTree(pre, startPre + 1, startPre + i - startIn, in, startIn, i - 1);
                /*
                 * 前序起始位置其实就是左子树前序结束下标+1，因为总的前序被分为两部分，一部分为左子树的前序，
                 * 一部分为右子树的前序，既然左子树的前序结束下标为endPre = startPre+i-startIn,
                 * 那么右子树的起始下标startIn=startPre+i-startIn+1
                 * 右子树的前序结束下标endPre = endPre
                 *
                 * 右子树的中序起始下标startIn同理，左右子树的中序也将总的中序分为两部分，而且处于查出来的中序根节点下标值的两边，
                 * 即左子树结束下标为i-1，右子树起始下标为i+1，而右子树的结束下标也自然而然是endIn。
                 * */
                root.right = reConstructBinaryTree(pre, startPre + i - startIn + 1, endPre, in, i + 1, endIn);
                //在中序中找到根节点直接退出循环
                break;
            }
        }
        return root;
    }

    /**
     * 中序后序重建二叉树
     */
    public static TreeNode reConstructBinaryTree1(int[] post, int[] in) {
        if (post == null || in == null || post.length != in.length || post.length < 1) {
            return null;
        }
        //调用递归
        TreeNode root = reConstructBinaryTree1(post, 0, post.length - 1, in, 0, in.length - 1);
        return root;
    }

    private static TreeNode reConstructBinaryTree1(int[] post, int startPost, int endPost, int[] in, int startIn, int endIn) {
        if (startPost > startPost || startIn > endIn) {
            return null;
        }
        //根节点为前序数组的第一个元素
        TreeNode root = new TreeNode(post[endPost]);
        for (int i = endPost; i >= 0; i--) {
            //根据后序遍历得到的根结点在中序遍历中查找根结点的下标i
            if (post[endPost] == in[i]) {

                root.left = reConstructBinaryTree1(post, startPost, startPost + i - startIn - 1, in, startIn, i - 1);

                root.right = reConstructBinaryTree1(post, startPost + i - startIn, endPost - 1, in, i + 1, endIn);
                break;
            }
        }
        return root;
    }
    public static void posOrderRecur(TreeNode head) {
        if (head == null) {
            return;
        }
        posOrderRecur(head.left);
        posOrderRecur(head.right);
        System.out.print(head.val + " ");
    }
    public static void preOrderRecur(TreeNode head) {
        if (head == null) {
            return;
        }
        System.out.print(head.val + " ");
        posOrderRecur(head.left);
        posOrderRecur(head.right);

    }

    public static void main(String[] args) {
        int[] preOrder = {3,9,20,15,7};
        int[] inOrder = {9,3,15,20,7};
        TreeNode result = reConstructBinaryTree(preOrder, inOrder);
        preOrderRecur(result);
    }

}
