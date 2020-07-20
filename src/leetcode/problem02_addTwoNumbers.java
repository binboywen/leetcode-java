package leetcode;

/**
 * 题目描述：
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 
 * 的方式存储的，并且它们的每个节点只能存储一位数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 */
class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
        val = x;
    }
    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
}
public class problem02_addTwoNumbers {
    private static ListNode addTwoNmubers(ListNode L1, ListNode L2){
        ListNode result = new ListNode(0);
        int carry = 0;
        ListNode curr = result;
        ListNode p = L1, q = L2;

        while(q != null || p != null){
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;

            if(p != null) p = p.next;
            if(q != null) q = q.next;
        }
        if(carry > 0){
            curr.next = new ListNode(carry);
        }
        return result.next;
    }

    public static void main(String [] args){
        ListNode r1 = new ListNode(2);
        ListNode r2 = new ListNode(4);
        ListNode r3 = new ListNode(3);
        r1.next = r2;
        r2.next = r3;
        r3.next = null;

        ListNode l1 = new ListNode(5);
        ListNode l2 = new ListNode(6);
        ListNode l3 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;
        l3.next = null;

        ListNode result = addTwoNmubers(r1, l1);
        ListNode curr = result;
        while(curr != null){
            System.out.print(curr.val);
            curr = curr.next;
        }


    }

}
