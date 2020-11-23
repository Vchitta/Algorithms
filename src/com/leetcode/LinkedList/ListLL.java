package com.leetcode.LinkedList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by vidyachitta on 10/31/19.
 */
 class ListNode {
     int val;
    ListNode next;
    ListNode() { }
    ListNode(int x) { val = x; }
    
}
 
 public class ListLL{
	 
	 ListNode head;
	     ListNode buildList(List<Integer> list){
	    	if(list.size() ==0) return null;
	    	ListNode head = new ListNode(list.get(0));
	    	ListNode temp = head;
	    	for(int i=1;i<list.size();i++){
	    		temp.next = new ListNode(list.get(i));
	    		temp= temp.next;
	    	}
	    	
	    	return head;
	    }
	     public void printList(ListNode head){
	     	while (head != null ) 
	     	{
	     		System.out.print(head.val);
	     		
	     		head = head.next;
	     	}
	     	System.out.println();
	     		return;
	     }
 

    public ListNode reverseListIterative(ListNode head) {
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
    public ListNode reverseListRecursive(ListNode head) {
    	// returning when there is no node or one node (equals reverse)
        if (head == null || head.next == null) return head;
           
        ListNode p = reverseListRecursive(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
    
    
    

    public static void main(String[] args) {
    	List<Integer> list ;
    	if(args.length >0){
    		list = new ArrayList<>();
    		for(int i=0;i<args.length;i++)
    			list.add(Integer.parseInt(args[i]));		
    	}
    	else
    		list = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));

    	ListLL listLL= new ListLL();
		ListNode head =listLL.buildList(list);
		listLL.printList(head);
		head = listLL.reverseListIterative(head);
		listLL.printList(head);
		head = listLL.reverseListIterative(head);
		listLL.printList(head);
    	
	}
}
