package com.study.daily.toplikedquestions;




public class Problem_0206_ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode dummy = new ListNode(0, null);
        ListNode pre = dummy;
        while (head != null){
            ListNode temp = head.next;
            head.next = pre.next;
            pre.next = head;
            head = temp;
        }
        return dummy.next;
    }

}
