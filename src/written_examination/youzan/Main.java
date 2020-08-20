package written_examination.youzan;

import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    class ListNode{
        int val;
        ListNode next;

    }

    public boolean isPalindrome (ListNode head) {
        Stack<Integer> stack = new Stack<>();
        if(head == null || head.next == null){
            return true;
        }
        ListNode cur = head;
        while(cur != null){
            ListNode next = cur.next;
            stack.push(cur.val);
            cur = next;
        }
        cur = head;
        while(cur != null){
            ListNode next =  cur.next;
            if(cur.val != stack.pop()){
                return false;
            }
            cur = next;
        }
        return true;
    }
}
