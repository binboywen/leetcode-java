package jianzhiOffer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 从尾到头反过来打印出每个结点的值。
 */
public class _06_printListFromTailToHead {
    /**
     * 使用递归
     * 要逆序打印链表 1->2->3（3,2,1)，可以先逆序打印链表 2->3(3,2)，
     * 最后再打印第一个节点 1。而链表 2->3 可以看成一个新的链表，
     * 要逆序打印该链表可以继续使用求解函数，
     * 也就是在求解函数中调用自己，这就是递归函数。
     * @param listNode
     * @return
     */
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode){
        ArrayList<Integer> ret = new ArrayList<>();
        if (listNode != null){
            ret.addAll(printListFromTailToHead(listNode.next));
            ret.add(listNode.val);
        }
        return ret;
    }

    /**
     * 头插法
     * @param listNode
     * @return
     */
    public static ArrayList<Integer> printListFromTailToHead_2(ListNode listNode){
        ListNode head = new ListNode(-1);
        while(listNode != null){
            ListNode temp = listNode.next;
            listNode.next = head.next;
            head.next = listNode;
            listNode = temp;
        }

        ArrayList<Integer> ret = new ArrayList<>();
        head = head.next;
        while(head != null){
            ret.add(head.val);
            head = head.next;
        }
        return ret;
    }

    /**
     * 使用栈
     * @param listNode
     * @return
     */
    public ArrayList<Integer> printListFromTailToHead_3(ListNode listNode){
        Stack<Integer> stack = new Stack<>();
        while(listNode != null){
            stack.add(listNode.val);
            listNode = listNode.next;
        }
        ArrayList<Integer> ret = new ArrayList<>();
        while(!stack.isEmpty()){
            ret.add(stack.pop());
        }
        return ret;
    }
}
