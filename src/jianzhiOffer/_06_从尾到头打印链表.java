package jianzhiOffer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 从尾到头反过来打印出每个结点的值。反转链表24
 */
public class _06_从尾到头打印链表 {
    /**
     * 使用递归
     * 要逆序打印链表 1->2->3（3,2,1)，可以先逆序打印链表 2->3(3,2)，
     * 最后再打印第一个节点 1。而链表 2->3 可以看成一个新的链表，
     * 要逆序打印该链表可以继续使用求解函数，
     * 也就是在求解函数中调用自己，这就是递归函数。
     */
    static ArrayList<Integer> arrayList = new ArrayList<>();
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode){

        if(listNode == null)
            return arrayList;
        printListFromTailToHeadRecu(listNode);
        return arrayList;

    }
    public static void printListFromTailToHeadRecu(ListNode root){
        if(root == null)
            return;
        printListFromTailToHeadRecu(root.next);
        arrayList.add(root.val);
    }

    /**
     * 头插法
     */
    public static ArrayList<Integer> printListFromTailToHead_2(ListNode listNode){
        ListNode head = new ListNode(-1);
        while(listNode != null){
            ListNode next = listNode.next;
            listNode.next = head.next;
            head.next = listNode;
            listNode = next;
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
