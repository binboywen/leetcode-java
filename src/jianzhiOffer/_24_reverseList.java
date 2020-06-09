package jianzhiOffer;

import java.util.List;

/**
 * 反转链表
 */
public class _24_reverseList {
    // 递归
    public ListNode ReverseList(ListNode head){
        if(head == null || head.next == null)
            return head;
        ListNode next = head.next;
        head.next = null;
        ListNode newHead = ReverseList(next);
        next.next = head;
        return newHead;
    }
    //迭代，使用头插法
    public ListNode ReverseList_2(ListNode head){
        ListNode newList = new ListNode(-1);
        while(head != null){
            ListNode next = head.next;
            head.next = newList.next;
            newList.next = head;
            head = next;
        }
        return newList.next;
    }

}
