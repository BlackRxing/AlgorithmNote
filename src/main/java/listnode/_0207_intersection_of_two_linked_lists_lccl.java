package listnode;
//其实很简单，尾部都是相同的，那么从尾部相同长度开始倒着遍历对比即可。
public class _0207_intersection_of_two_linked_lists_lccl {
    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            int len1=0,len2=0,gap;
            ListNode cur1=headA,cur2=headB;
            while(cur1!=null){
                cur1=cur1.next;
                len1++;
            }
            while(cur2!=null){
                cur2=cur2.next;
                len2++;
            }
            gap=len1>len2?len1-len2:len2-len1;
            cur1=headA;
            cur2=headB;
            if(len1>len2){
                for(int i=0;i<gap;i++){
                    cur1=cur1.next;
                }
            }else{
                for(int i=0;i<gap;i++){
                    cur2=cur2.next;
                }
            }
            while(cur1!=null){
                if(cur1==cur2){
                    return cur1;
                }
                cur1=cur1.next;
                cur2=cur2.next;
            }
            return null;
        }
    }
}
