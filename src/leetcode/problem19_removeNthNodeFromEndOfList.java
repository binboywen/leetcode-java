package leetcode;

/**
 * 题目描述：
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * 示例：
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 * 给定的 n 保证是有效的
 */
public class problem19_removeNthNodeFromEndOfList {
    /**
     * 两次遍历法
     * @param head
     * @param n
     * @return
     */
    private static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = head;
        int length = 0;
        while(temp != null){
            length++;
            temp = temp.next;
        }
        int removeAddress = length - n;
        if(removeAddress == 0)
            return head.next;
        ListNode p,q;
        p = head;
        int j = 1;
        while(p.next!=null  && (j < removeAddress)){
            p = p.next;
            j++;
        }
        q = p.next;
        p.next = q.next;
        return head;
    }

    /**
     * 一次遍历法
     * @param head
     * @param n
     * @return
     */
    private static ListNode removeNthFromEnd_2(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        // Advances first pointer so that the gap between first and second is n nodes apart
        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }
        // Move first to the end, maintaining the gap
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }

    public static void main(String [] args){
        ListNode head = new ListNode(1);
        ListNode head2 = new ListNode(2);
        ListNode head3 = new ListNode(3);
        ListNode head4 = new ListNode(4);
        ListNode head5 = new ListNode(5);
        head.next = head2;
//        head2.next = head3;
//        head3.next = head4;
//        head4.next = head5;
        ListNode result = removeNthFromEnd(head, 2);
        System.out.println("  ");
    }
}
