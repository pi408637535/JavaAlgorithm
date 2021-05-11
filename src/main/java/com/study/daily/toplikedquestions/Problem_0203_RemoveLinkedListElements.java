package com.study.daily.toplikedquestions;

public class Problem_0203_RemoveLinkedListElements {
    public static ListNode removeElements(ListNode head, int val) {
        if(head == null){
            return null;
        }
        ListNode dummy = new ListNode(0, null);
        ListNode pre = dummy;
        while (head != null){
            if(!(head.val == val)){
                pre.next = head;
                pre = pre.next;
            }
            head = head.next;
        }
        pre.next = null;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;

        ListNode node = removeElements(listNode1, 1);
        System.out.println(node);
    }
}
