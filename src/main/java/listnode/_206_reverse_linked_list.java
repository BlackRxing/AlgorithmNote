package listnode;
//使用双指针思想，容易写错的地方是第10行容易写成cur.next!=null,16行容易写成return cur
public class _206_reverse_linked_list {
    class Solution {
        public ListNode reverseList(ListNode head) {
            if(head==null){
                return head;
            }
            ListNode cur=head,pre=null,node;
            while(cur!=null){
                node=cur.next;
                cur.next=pre;
                pre=cur;
                cur=node;
            }
            return pre;
        }
    }
}
