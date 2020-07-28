package jianzhiOffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * 按层遍历二叉树
 * 从上到下打印二叉树的每一个节点
 * 同一层节点保证从左到右的顺序打印
 * 可以借助队列来完成，
 * 把要打印的节点放入队列中，
 * 弹出一个节点时打印并且同时压入该节点的左右孩子（如果其孩子不为空的话）
 */
public class _32_1_从上到下打印二叉树 {
    public ArrayList<Integer> PrintTreeFromTopToBottom(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> ret = new ArrayList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int cnt = queue.size();
            while(cnt-->0){
                TreeNode t = queue.poll();
                if(t == null){
                    continue;
                }
                ret.add(t.val);
                queue.add(t.left);
                queue.add(t.right);
            }
        }
        return ret;
    }
}
