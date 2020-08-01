package jianzhiOffer;

import java.util.*;

/**
 * Z字形打印二叉树
 * 第一行从左到右
 * 第二行从右往左
 * 以此类推
 */
public class _32_3_Z字形打印二叉树 {
    /**
     * 当打印根节点的时候，它的左子节点和右子节点，先后保存到一个
     * 数据容器里面，在打印第二层的节点时候，先打印右子节点，再打印左子节点
     * 在打印第三层节点的时候，先打印第二层左边节点的左右孩子，再打印右边节点
     * 的左右孩子，因此我们可以使用栈结构来对节点进行存储
     * 规律：按之字形顺序打印二叉树需要两个栈，我们再打印某一层节点时，把
     * 下一层节点保存在相应的栈里，如果当前打印的是奇数层，则先保存左子节点
     * 再保存右子节点到第一个栈里，如果当前打印层是偶数层，则先保存右子节点
     * 再保存左子节点到第二个栈里。
     */
    public ArrayList<ArrayList<Integer>> ZigZagPrintTree(TreeNode root){
        if(root == null)
            return null;
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean reverse = false;
        while(!queue.isEmpty()){
            ArrayList<Integer> list = new ArrayList<>();
            int cnt = queue.size();
            while(cnt-- > 0){
                TreeNode node = queue.poll();
                if(node == null){
                    continue;
                }
                list.add(node.val);
                queue.add(node.left);
                queue.add(node.right);
            }
            if(reverse){
                Collections.reverse(list);
            }
            reverse = !reverse;
            if(list.size() != 0)
                ret.add(list);
        }
        return ret;


    }

}
