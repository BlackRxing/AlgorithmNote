package listnode;
//快慢指针可以实现单次遍历
public class _19_remove_nth_node_from_end_of_list {
    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            if(head==null){
                return head;
            }
            ListNode fast=head,slow,vhead; //建议使用虚拟头节点，否则如果删除的是头部节点肯定要单独处理
            slow=new ListNode(-1);
            vhead=slow;
            slow.next=head;
            for(int i=0;i<n;i++){ //快慢指针之间跳数应该为n+1,slow应该是被删除的节点的前一个节点！
                fast=fast.next;
            }
            while(fast!=null){
                fast=fast.next;
                slow=slow.next;
            }
            slow.next=slow.next.next;
            return vhead.next;  //这里很容易写成head，想一想如果头节点是被删除的节点还能返回head吗？
        }
    }
}
