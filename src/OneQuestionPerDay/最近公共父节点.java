package OneQuestionPerDay;

import java.util.Stack;

class TreeNodeP {
    TreeNodeP left;
    TreeNodeP right;
    TreeNodeP parent;
    int val;
    TreeNodeP(int data){
        val = data;
    }
}
public class 最近公共父节点 {
    /**test
     给定一颗二叉树，以及其中的两个node（地址均非空），
     要求给出这两个node的一个公共父节点，
     使得这个父节点与两个节点的路径之和最小。
     描述你程序的最坏时间复杂度，并实现具体函数
     */
    //  先查找高度。然后类似于查找两条链表第一个公共节点的方法进行遍历比较
    // O(N)
    TreeNodeP LowestCommAncestor(TreeNodeP first, TreeNodeP second){
        int height1 = getHeight(first);
        int height2 = getHeight(second);
        int diff = height1 - height2;
        if(diff < 0){
            diff = -diff;
            while(diff-- > 0){
                second = second.parent;
            }
        }else{
            while(diff-- > 0)
                first = first.parent;
        }
        while(first != second){
            first = first.parent;
            second = second.parent;
        }
        return first;
    }
    int getHeight(TreeNodeP node){
        int height = 0;
        while(node != null){
            height++;
            node = node.parent;
        }
        return height;
    }
    //使用辅助存储空间。两个栈依次压入从该节点到根节点的指针。依次弹出栈比较节点。。
    TreeNodeP LowestCommAncestor2(TreeNodeP first, TreeNodeP second){
        if(first == second)
            return first;
        Stack<TreeNodeP> s1 = new Stack<>();
        Stack<TreeNodeP> s2 = new Stack<>();
        while(first != null){
            s1.push(first);
            first = first.parent;
        }
        while(second != null){
            s2.push(second);
            second = second.parent;
        }
        while(!s1.isEmpty() && !s2.isEmpty()){
            TreeNodeP t1 = s1.pop();
            TreeNodeP t2 = s2.pop();
            if(t1 != t2) return null;
            else if((t1 == t2) && !s1.isEmpty() && !s2.isEmpty()&&(s1.peek() != s2.peek())) return t1;
            else if((t1 == t2) &&(s1.isEmpty() || s2.isEmpty())) return t1;
        }
        return null;
    }
}
