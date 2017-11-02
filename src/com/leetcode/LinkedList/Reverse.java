package com.leetcode.LinkedList;

/**
 * Created by vidyachitta on 7/13/17.
 */
 class ListNode {
     int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
public class Reverse {
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ListNode first = head.next;
        head.next =  null;
        ListNode temp = head;
        while (first != null){

            ListNode second = first.next;
            first.next=temp;
            temp = first;
            first = second;

        }

        return temp;
    }
}
