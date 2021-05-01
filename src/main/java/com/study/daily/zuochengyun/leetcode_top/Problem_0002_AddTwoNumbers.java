package com.study.daily.zuochengyun.leetcode_top;

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
 ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Problem_0002_AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null){
            return null;
        }else if(l1 == null && l2 != null){
            return l2;
        }else if(l1 != null && l2 == null){
            return l1;
        }else{
            //l1、l2 aren't null
            ListNode dummy = new ListNode();
            ListNode head = dummy;

            int carryOver = 0;
            int res = 0;
            while (l1 != null && l2 != null){
                res = l1.val + l2.val + carryOver;
                carryOver = res  >= 10 ? 1 : 0;
                res = res % 10;
                ListNode node = new ListNode();
                node.val = res;
                head.next = node;
                l1 = l1.next;
                l2 = l2.next;
                head = head.next;
            }
            while (l1 != null){
                res = l1.val + carryOver;
                carryOver = res >= 10 ? 1 : 0;
                res = res % 10;
                ListNode node = new ListNode();
                node.val = res;
                head.next = node;
                l1 = l1.next;
                head = head.next;
            }

            while (l2 != null){
                res = l2.val + carryOver;
                carryOver = res >= 10 ? 1 : 0;
                res = res % 10;
                ListNode node = new ListNode();
                node.val = res;
                head.next = node;
                l2 = l2.next;
                head = head.next;
            }

            if (carryOver == 1){
                ListNode node = new ListNode();
                node.val = 1;
                head.next = node;
            }

            return dummy.next;
        }
    }

    public static void main(String[] args) {
//        ListNode ListNode2 = new ListNode(2);
//        ListNode ListNode4_1 = new ListNode(4);
//        ListNode ListNode3 = new ListNode(3);
//
//        ListNode2.next = ListNode4_1;
//        ListNode4_1.next = ListNode3;
//
//        ListNode ListNode5 = new ListNode(5);
//        ListNode ListNode6 = new ListNode(6);
//        ListNode ListNode4_2 = new ListNode(4);
//
//        ListNode5.next = ListNode6;
//        ListNode6.next = ListNode4_2;
//
//        ListNode node = new Problem_0002_AddTwoNumbers().addTwoNumbers(ListNode2, ListNode5);
        ListNode ListNode1 = new ListNode(1);

        ListNode ListNode9_1 = new ListNode(9);
        ListNode ListNode9_2 = new ListNode(9);
        ListNode9_1.next = ListNode9_2;
        ListNode node = new Problem_0002_AddTwoNumbers().addTwoNumbers(ListNode9_1, ListNode1);

        System.out.println(node);

    }
}
