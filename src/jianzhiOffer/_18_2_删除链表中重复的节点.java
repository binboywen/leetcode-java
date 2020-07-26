package jianzhiOffer;

/**
 * 删除链表中重复的节点
 */
public class _18_2_删除链表中重复的节点 {
    //递归
    public ListNode deleteDuplication(ListNode pHead){
        if(pHead == null || pHead.next == null)
            return pHead;
        ListNode next = pHead.next;
        if(pHead.val == next.val){
            while(next!=null && pHead.val == next.val){
                next = next.next;
            }
            return deleteDuplication(next);
        }
        else{
            pHead.next = deleteDuplication(pHead.next);
            return pHead;
        }
    }
    //非递归
    public ListNode deleteDuplication1(ListNode pHead){
        if(pHead == null || pHead.next == null)
            return pHead;
        ListNode head = new ListNode(-1);
        head.next = pHead;
        ListNode pre = head;
        ListNode last = head.next;
        while(last != null){
            if(last.next != null && last.val == last.next.val){
                while(last.next != null && last.val == last.next.val)
                    last = last.next;
                pre.next = last.next;
                last = last.next;
            }else{
                pre = pre.next;
                last = last.next;
            }
        }
        return head.next;
    }
}
