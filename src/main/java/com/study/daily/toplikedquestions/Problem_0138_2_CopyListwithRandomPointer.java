package com.study.daily.toplikedquestions;


import java.util.HashMap;
import java.util.Map;

//Todo leetcode报有指向旧节点情况，但是没发现
public class Problem_0138_2_CopyListwithRandomPointer {
    public Node copyRandomList(Node head) {
        if(head == null){
            return head;
        }
        Node original = head;
        while (head != null){
            Node newNode = new Node(head.val);
            Node temp = head.next;
            head.next = newNode;
            newNode.next = temp;
            head = temp;
        }
        head = original;
        Node dummy = new Node(0);
        Node cur = dummy;
        while (head != null){
            cur.next = head.next;
            if(head.random != null) {
                cur.next.random = head.random.next;
            }
            cur = cur.next;
            head = head.next.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        Node node7 = new Node(7);
        Node node13 = new Node(13);
        Node node11 = new Node(11);
        Node node10 = new Node(10);
        Node node1 = new Node(1);

        node7.next = node13;
        node13.next = node11;
        node11.next = node10;
        node10.next = node1;

        node13.random = node7;
        node11.random = node1;
        node10.random = node11;
        node1.random = node7;

        Node node = new Problem_0138_2_CopyListwithRandomPointer().copyRandomList(node7);
        System.out.println(node);
    }
}
