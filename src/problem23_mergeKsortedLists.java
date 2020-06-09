import java.util.*;

/**
 * 题目描述：
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 * 示例:
 * 输入:
 * [  1->4->5,
 *   1->3->4,
 *   2->6
 * ]输出: 1->1->2->3->4->4->5->6
 */
public class problem23_mergeKsortedLists {
    /**
     * 暴力法
     * @param lists
     * @return
     */
    private static ListNode mergeKLists_1(ListNode [] lists){
        List<Integer> list_int = new ArrayList<>();
        ListNode head = new ListNode(0);
        ListNode point = head;
        for(ListNode temp : lists){
            while (temp != null){
                list_int.add(temp.val);
                temp = temp.next;
            }
        }
        Collections.sort(list_int);
        for(int i : list_int){
            point.next = new ListNode(i);
            point = point.next;
        }
        return head.next;
    }

    /**
     * 逐一比较
     * @param lists
     * @return
     */
    private static ListNode mergeKList_2(ListNode [] lists){
        ListNode head = new ListNode(0);
        ListNode point = head;
        ListNode curr = new ListNode(65535);
        boolean flag = true;
        while(flag){
            flag = false;
            curr.val = 65535;
            int index = -1;
            for(int i = 0; i < lists.length; i++){
                if(lists[i] == null){
                    //index++;
                    continue;
                }
                ListNode temp = lists[i];
                if(temp.val < curr.val) {
                    curr = temp;
                    flag = true;
                    index = i;
                }
            }
            if (!flag)
                return head.next;
            point.next = new ListNode(curr.val);
            point = point.next;
            lists[index] = lists[index].next;
        }
        return head.next;
    }

    //匿名Comparator实现
    private static Comparator<ListNode> listNodeComparator = new Comparator<ListNode>(){
        @Override
        public int compare(ListNode listNode1, ListNode listNode2) {
            return (int) (listNode1.getVal() - listNode2.getVal());
        }
    };

    /**
     * 优化方法二，在比较环节使用优先队列进行优化
     * @param lists
     * @return
     */
    private static ListNode mergeKList_3(ListNode [] lists){
        ListNode head = new ListNode(0);
        ListNode point = head;
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(7,listNodeComparator);
        for(ListNode l : lists){
            if(l != null){
                priorityQueue.add(l);
            }
        }
        while(!priorityQueue.isEmpty()){
            ListNode node = priorityQueue.poll();
            point.next = new ListNode(node.val);
            point = point.next;
            node = node.next;
            if(node != null){
                priorityQueue.add(node);
            }
        }
        return head.next;
    }

    /**
     * 将合并K个链表的问题转化成合并2个链表K-1次
     * @param lists
     * @return
     */
    private static ListNode mergeKList_4(ListNode [] lists){
        if(lists.length == 0)
            return null;
        if( lists.length == 1)
            return lists[0];
        ListNode curr = lists[0];
        for (int i = 1; i < lists.length; i++){
            curr = problem21_mergeTwoLists.mergeTwoLists_4(curr, lists[i]);
        }
        return curr;
    }

    /**
     *分治，K个链表两两合并后，还有K/2个链表，依次类推
     * @return
     */
    private static ListNode mergeKList_5(ListNode [] lists){
        int amount = lists.length;
        int interval = 1;
        while(interval < amount){
            for (int i = 0; i < amount - interval; i += interval * 2){
                lists[i] = problem21_mergeTwoLists.mergeTwoLists_4(lists[i], lists[i + interval]);
            }
            interval *= 2;
        }
        if(amount > 0) return lists[0];
        else return null;
    }

    public static void main(String [] args){
        ListNode r1 = new ListNode(1);
        ListNode r2 = new ListNode(4);
        ListNode r3 = new ListNode(5);
        r1.next = r2;
        r2.next = r3;
        r3.next = null;

        ListNode f1 = new ListNode(2);
        ListNode f2 = new ListNode(6);
        f1.next = f2;
        f2.next = null;

        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(3);
        ListNode l3 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;
        l3.next = null;

        ListNode [] lists ={r1, l1};
        ListNode result = mergeKList_5(lists);
        System.out.println(" ");
    }
}
