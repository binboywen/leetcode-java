package jianzhiOffer;

import java.util.List;

/**
 * 一个链表中包含环，请找出该链表的环的入口节点
 * 要求不能使用额外的空间
 */
public class _23_EntryNodeOfLoop {
    /**
     * 1.如何确定链表中包含环：使用双指针，一个指针fast每次移动两个节点，一个指针
     * slow每次移动一个节点。因为存在环，所以两个指针必定相遇再
     * 环中的某个节点上。2.如何找到环的入口：先定义两个指针P1和P2指向链表的头节点。
     * 如果链表中的环有n个节点，则指针P1先在链表上向前移动n步，然后两个
     * 指针以相同的速度向前移动。当第二个指针指向环的入口节点时，第一
     * 个指针已经围绕着环走了一圈，又回到了入口节点。3.如何得到环中节点的数目。两个
     * 指针相遇一定是在环中，可以从这个节点出发，一边继续向前移动一边计数，当
     * 再次回到这个节点时，就可以得到环中节点数了。
     */
    //如下代码在链表中存在环的前提下找到一快一慢两个指针的相遇的节点
    ListNode MeetingNode(ListNode pHead){
        if(pHead == null){
            return null;
        }
        ListNode pSlow = pHead.next;
        if(pSlow == null)
            return null;
        ListNode pFast = pSlow.next;
        while(pFast != null && pSlow != null){
            if(pFast == pSlow)
                return pFast;
            pSlow = pSlow.next;
            pFast = pFast.next;
            if(pFast.next != null)
                pFast = pFast.next;
        }
        return null;
    }
    //找到环中任意一个节点之后，就能得出环中的节点数目，并找到环的入口节点
    ListNode EntryNodeOfLoop(ListNode pHead){
        ListNode meetingNode = MeetingNode(pHead);
        if(meetingNode == null)
            return null;

        //得到环中节点的数目
        int nodesInLoop = 1;
        ListNode pNode1 = meetingNode;
        while(pNode1.next != meetingNode){
            pNode1 = pNode1.next;
            ++nodesInLoop;
        }

        //先移动pNode1，次数为环中节点的数目
        pNode1 =  pHead;
        for(int i = 0; i < nodesInLoop; ++i){
            pNode1 = pNode1.next;
        }
        //再移动pNode1和pNode2
        ListNode pNode2 = pHead;
        while(pNode1 != pNode2){
            pNode1 = pNode1.next;
            pNode2 = pNode2.next;
        }
        return pNode1;
    }
}
