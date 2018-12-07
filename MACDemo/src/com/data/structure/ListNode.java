package com.data.structure;

public class ListNode {
	
	int val;
    ListNode next;
    
    public ListNode(int x){
        val=x;
    }
    
    //两个链表数值相加
    public ListNode addTwoNumbers(ListNode l1,ListNode l2){
        ListNode dummyHead = new ListNode(0);
        ListNode p=l1,q=l2,curr=dummyHead;
        int carry=0;//进位
        while(p!=null || q!=null){
            int x=(p!=null)?p.val:0;
            int y=(q!=null)?q.val:0;
            int sum=x+y+carry;
            carry=sum/10;
            curr.next=new ListNode(sum%10);
            curr=curr.next;
            if(p!=null) p=p.next;
            if(q!=null) q=q.next;
        }
        if(carry>0){
            curr.next=new ListNode(carry);
        }
        
        return dummyHead.next;
    }
    
    public static void main(String[] args) {
		
	}



}
