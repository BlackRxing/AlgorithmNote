package listnode;
//需要用到虚拟节点思想，三指针思想
public class _24_swap_nodes_in_Paris {
    class Solution {
        public ListNode swapPairs(ListNode head) {
            if(head==null||head.next==null){
                return head;
            }
            ListNode pre=head,cur=head.next,vhead=new ListNode(-1);
            vhead.next=head; //创建虚拟头部节点
            head=cur;  //容易漏掉
            while(true){
                vhead.next=cur;  //顺序有讲究
                pre.next=cur.next;
                cur.next=pre;
                System.out.println(pre.val+" "+cur.val);
                if(pre.next==null||pre.next.next==null){  //还有单个节点就先推出
                    break;
                }
                vhead=pre;
                pre=pre.next;
                cur=pre.next;
            }
            return head;
        }
    }
}

//递归版本，写的也十分巧妙
class Solution {
    public ListNode swapPairs(ListNode head) {
        // base case 退出提交
        if(head == null || head.next == null) return head;
        // 获取当前节点的下一个节点
        ListNode next = head.next;
        // 进行递归
        ListNode newNode = swapPairs(next.next);
        // 这里进行交换
        next.next = head;
        head.next = newNode;

        return next;
    }
}