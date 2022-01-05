package hash;

import org.w3c.dom.Node;

import java.util.HashMap;
import java.util.Map;
//主要问题在于新序列的点创立后再次需要使用如何确定，很简单：建立源节点与复制后的节点的hashmap
public class _138_copy_list_with_random_pointer {
    /*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

    class Solution {
        public Node copyRandomList(Node head) {
            Map<Node,Node> map=new HashMap();
            Node cur=head;
            if(head==null){
                return null;
            }
            while(cur!=null){
                map.put(cur,new Node(cur.val));
                cur=cur.next;
            }
            cur=head;
            while(cur!=null){
                map.get(cur).next=map.get(cur.next);
                map.get(cur).random=map.get(cur.random);
                cur=cur.next;
            }
            return map.get(head);
        }
    }
}
