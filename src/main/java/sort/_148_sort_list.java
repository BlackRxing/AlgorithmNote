package sort;

import listnode.ListNode;

public class _148_sort_list {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode sortList(ListNode head) {
            if(head==null||head.next==null){
                return head;
            }
            ListNode slow=head;
            ListNode fast=head.next;
            while(fast!=null&&fast.next!=null){
                slow=slow.next;
                fast=fast.next.next;
            }
            ListNode b=slow.next;

            ListNode a=head;
            slow.next=null;
            a=sortList(a);
            b=sortList(b);
            return sort(a,b);
        }
        ListNode sort(ListNode a,ListNode b){
            ListNode head;
            ListNode cur=new ListNode();
            head=cur;
            while(a!=null||b!=null){
                if(a==null||(b!=null&&a.val>=b.val)){
                    cur.next=b;
                    b=b.next;
                }else{
                    cur.next=a;
                    a=a.next;
                }
                cur=cur.next;
            }
            ListNode x=head;
            cur.next=null;
            return head.next;
        }
    }
}
