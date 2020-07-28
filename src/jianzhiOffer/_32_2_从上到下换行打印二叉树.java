package jianzhiOffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 分行从上到下打印二叉树
 * 每一层打印在一行上面
 * 和上一题类似，也可以使用一个队列来保存将要打印的节点
 * 我们需要两个变量，一个变量表示在当前层中还没有打印的节点数
 * 另一个表示下一层的节点数
 */
public class _32_2_从上到下换行打印二叉树 {
    public List<List<Integer>> levelOrder(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> ret = new ArrayList<>();
        if(root == null){
            return ret;
        }
        queue.add(root);
        while(!queue.isEmpty()){
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                if(node == null){
                    continue;
                }
                list.add(node.val);
                queue.add(node.left);
                queue.add(node.right);
            }
            if(list.size() != 0){
                ret.add(list);
            }

        }
        return ret;
    }
    public void PrintTree(TreeNode root){
        if(root == null)
            return;
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        queue.add(root);
        int nextLevel = 0;
        int toBePrinted = 1;
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            System.out.println(node.val);
            if(node.left != null){
                queue.add(node.left);
                nextLevel++;
            }
            if(node.right != null){
                queue.add(node.right);
                nextLevel++;
            }
            --toBePrinted;
            if(toBePrinted == 0){
                System.out.println("\n");
                toBePrinted=nextLevel;
                nextLevel=0;
            }
        }
    }
}
