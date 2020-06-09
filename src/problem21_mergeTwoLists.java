/**
 * 题目描述：
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 */

public class problem21_mergeTwoLists {
    private static ListNode mergeTwoLists_1(ListNode L1, ListNode L2){
        if(L1 == null){
            return L2;
        }
        if(L2 == null){
            return L1;
        }
        ListNode result = new ListNode(0);
        ListNode p = L1;
        ListNode q = L2;
        ListNode curr = result;
        while(p != null || q != null){
            if(p == null){
                if(q != null){
                    curr.next = new ListNode(q.val);
                    curr = curr.next;
                    q = q.next;
                }
            }
            if(q == null){
                if(p != null){
                    curr.next = new ListNode(p.val);
                    curr = curr.next;
                    p = p.next;
                }
            }
            if(p != null && q != null){
                if(p.val < q.val){
                    curr.next = new ListNode(p.val);
                    curr = curr.next;
                    if( p != null) p = p.next;
                }
                else{
                    curr.next = new ListNode(q.val);
                    curr = curr.next;
                    if(q != null) q = q.next;
                }
            }
        }
        return result.next;
    }

    private static ListNode mergeTwoLists_2(ListNode L1, ListNode L2){
        ListNode result = new ListNode(0);
        ListNode p = L1, q = L2, curr = result;
        while(p != null || q != null){
            int x = p==null?65535:p.val;
            int y = q==null?65535:q.val;
            if(x < y){
                curr.next = new ListNode(x);
                if(p != null) p = p.next;
            }else{
                curr.next = new ListNode(y);
                if(q != null) q = q.next;
            }
            curr = curr.next;
        }
        return result.next;
    }

    public static ListNode mergeTwoLists_3(ListNode L1, ListNode L2){
        if(L1 == null) return L2;
        else if (L2 == null) return L1;
        else if (L1.val < L2.val) {
            L1.next = mergeTwoLists_3(L1.next, L2);
            return L1;
        }else{
            L2.next = mergeTwoLists_3(L1, L2.next);
            return L2;
        }
    }

    public static ListNode mergeTwoLists_4(ListNode l1, ListNode l2){
        ListNode prehead = new ListNode(-1);
        ListNode prev = prehead;
        while(l1 != null && l2 != null){
            if (l1.val <= l2.val){
                prev.next = l1;
                l1 = l1.next;
            }else{
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        prev.next = l1==null?l2:l1;
        return prehead.next;
    }

    public static void main(String [] args){
        ListNode r1 = new ListNode(1);
        ListNode r2 = new ListNode(2);
        ListNode r3 = new ListNode(3);
        r1.next = r2;
        r2.next = r3;
        r3.next = null;

        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(3);
        ListNode l3 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;
        l3.next = null;

        ListNode result = mergeTwoLists_4(r1, l1);
        ListNode curr = result;
        while(curr != null){
            System.out.print(curr.val);
            curr = curr.next;
        }
    }
}
