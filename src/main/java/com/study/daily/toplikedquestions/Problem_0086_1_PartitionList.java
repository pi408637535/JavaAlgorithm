package com.study.daily.toplikedquestions;

public class Problem_0086_1_PartitionList {
    public ListNode partition(ListNode head, int x) {
        if(head == null){
            return head;
        }

        ListNode ltDummy = new ListNode();
        ListNode ltCur = ltDummy;

        ListNode restDummy = new ListNode();
        ListNode restCur = restDummy;


        while (head != null){
            if(head.val < x){
                ltCur.next = head;
                ltCur = ltCur.next;
            }else{
                restCur.next = head;
                restCur = restCur.next;
            }
            head = head.next;
        }

        if(ltDummy.next == null){
            restCur.next = null;
            return restDummy.next;
        }else{
            ltCur.next = restDummy.next;
            restCur.next = null;
            return ltDummy.next;
        }

    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode2_1 = new ListNode(2);
        ListNode listNode5 = new ListNode(5);
        ListNode listNode2_2 = new ListNode(2);

        listNode1.next = listNode4;
        listNode4.next = listNode3;
        listNode3.next = listNode2_1;
        listNode2_1.next = listNode5;
        listNode5.next = listNode2_2;

        ListNode rest = new Problem_0086_1_PartitionList().partition(listNode1, 9);
        System.out.println(rest);


    }
}
