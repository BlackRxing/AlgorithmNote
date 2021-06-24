package listnode;
//比判断是否有环更进一步
public class _142_linked_lsit_cycle_II {
    public class Solution {
        public ListNode detectCycle(ListNode head) {
            ListNode fast=head;
            ListNode slow=head;
            while(fast!=null&&fast.next!=null){
                slow=slow.next;
                fast=fast.next.next;
                if(fast==slow){
                    slow=head;
                    while(fast!=slow){
                        fast=fast.next;
                        slow=slow.next;
                    }
                    return fast;
                }
            }
            return null;
        }
    }
}
