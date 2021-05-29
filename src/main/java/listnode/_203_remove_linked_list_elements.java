package listnode;

public class _203_remove_linked_list_elements {
    //第一种写法，将需要处理的头部节点首先遍历掉
    class Solution {
        public ListNode removeElements(ListNode head, int val) {
            ListNode pre=null,cur;
            while(head!=null&&head.val==val){
                head=head.next;
            }
            if(head==null){
                return head;
            }
            cur=head;
            while(cur!=null){
                if(cur.val==val){
                    pre.next=cur.next;
                    cur=cur.next;
                }else{
                    pre=cur;
                    cur=cur.next;
                }
            }
            return head;
        }
    }
    //第二种写法，创造一个虚拟头部节点，代码最简洁
        public ListNode removeElements(ListNode head, int val) {
            ListNode newHead=new ListNode(-1,head);
            ListNode pre=newHead,cur=head;
            while(cur!=null){
                if(cur.val==val){
                    pre.next=cur.next;
                }else{
                    pre=cur;
                }
                cur=cur.next;
            }
            return newHead.next;
        }

}
