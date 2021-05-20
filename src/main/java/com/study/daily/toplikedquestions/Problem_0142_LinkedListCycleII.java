package com.study.daily.toplikedquestions;

public class Problem_0142_LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        if(head == null){
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;

        if(fast.next == null || fast.next.next == null){
            return null;
        }

        while (fast != null && fast.next != null && fast.next.next != null ){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow)
                break;
        }
        if(fast == null || fast.next == null || fast.next.next == null){
            return null;
        }
        fast = head;
        while (fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }

    public static void main(String[] args) {
        ListNode ListNode3 = new ListNode(3);
        ListNode ListNode2 = new ListNode(2);
        ListNode ListNode0 = new ListNode(0);
        ListNode ListNode_4 = new ListNode(-4);

        ListNode3.next = ListNode2;
        ListNode2.next = ListNode0;
        ListNode0.next = ListNode_4;
        ListNode_4.next = ListNode2;

        ListNode node = new Problem_0142_LinkedListCycleII().detectCycle(ListNode3);
        System.out.println(node);

    }
}
