package com.study.daily.toplikedquestions;


import java.util.HashMap;
import java.util.Map;



public class Problem_0138_CopyListwithRandomPointer {
    public Node copyRandomList(Node head) {
        if(head == null){
            return head;
        }
        Map<Node, Node> oldNewMap = new HashMap<>();
        Node temp = head;
        while (head != null){
            Node newNode = new Node(head.val);
            oldNewMap.put(head, newNode);
            head = head.next;
        }
        Node dummy = new Node(0);
        Node cur = dummy;
        head = temp;
        while (head != null){
            Node newNode = oldNewMap.get(head);
            newNode.random = oldNewMap.get(head.random);
            cur.next = newNode;
            head = head.next;
            cur = cur.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {

    }
}
