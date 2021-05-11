package binarytree;

import org.w3c.dom.Node;

import java.util.LinkedList;
import java.util.Queue;

public class _116_Populating_next_right_pointers_in_each_node {

// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};


    class Solution {
        public Node connect(Node root) {
            Queue<Node> queue=new LinkedList();

            if(root==null){
                return root;
            }
            queue.offer(root);
            while(!queue.isEmpty()){
                Node cur=null;
                Node before=null;
                int size=queue.size();
                for(int i=0;i<size;i++){
                    cur=queue.poll();
                    if(cur.left!=null){
                        queue.offer(cur.left);
                    }
                    if(cur.right!=null){
                        queue.offer(cur.right);
                    }
                    if(before!=null){
                        before.next=cur;
                    }
                    before=cur;
                }
                cur.next=null;
            }
            return root;
        }
    }
}
