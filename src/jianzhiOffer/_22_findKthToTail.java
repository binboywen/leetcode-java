package jianzhiOffer;

/**
 * 输入一个链表，输出该链表中倒数第k个节点。
 * 从1开始计数，即链表的尾节点是倒数第一个节点。
 */
public class _22_findKthToTail {
    /**
     * 通常的想法是先走到链表的尾端，再从尾端回溯k步。
     * 但是单链表没有存储父指针。
     * 另一想法是，遍历这个链表两次，首先获取这个链表的长度n，
     * 那么倒数第k个节点就是从头节点开始的第n-k+1个节点。
     * 最佳方法是，一次遍历，定义两个指针，第一个指针从链表的头
     * 指针开始遍历向前走k-1步，第二个指针保持不动，从第k步开始，
     * 第二个指针也开始从链表的头指针开始遍历。由于两个指针的距离
     * 保持再k-1，当第一个指针到达链表的尾节点时，第二个指针正好
     * 指向倒数第k个节点。
     */
    // 需要注意的输入情况：
    // 1.链表为空
    // 2.链表节点数少于k
    // 3.k为0
    public ListNode FindKthToTail(ListNode head, int k){
        if(head == null)
            return null;
        if(k <= 0)
            return null;
        ListNode P1 = head;
        while(P1 != null && k-->0){
            P1 = P1.next;
        }
        if(k > 0)
            return null;
        ListNode P2 = head;
        while(P1 != null) {
            P1 = P1.next;
            P2 = P2.next;
        }
        return P2;
    }
    /**
     * 扩展：求链表的中间节点，一个指针走一步，一个指针走两步
     */

}
