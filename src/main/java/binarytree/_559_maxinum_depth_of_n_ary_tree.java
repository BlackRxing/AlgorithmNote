package binarytree;

import java.util.List;
import java.util.Stack;
//可以用层次遍历，可以用迭代，可以用后序遍历，该方法使用后序遍历
public class _559_maxinum_depth_of_n_ary_tree {

// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};


    class Solution {
        public int maxDepth(Node root) {
            Stack<Node> stack=new Stack();
            stack.push(root);
            if(root==null){
                return 0;
            }
            int depth=0;
            int ans=0;
            while(!stack.isEmpty()){
                Node cur=stack.pop();
                if(cur!=null){
                    depth++;
                    stack.push(cur);
                    stack.push(null);
                    for(Node node:cur.children){
                        if(node!=null){
                            stack.push(node);
                        }
                    }
                }else{
                    stack.pop();
                    depth--;
                }
                ans=depth>ans?depth:ans;
            }
            return ans;
        }
    }
}

//也可以使用先序遍历的递归写法，其他写法不可以，因为不具有先序遍历的灵活性，函数体内变量得以保留
//class Solution {
//    public int countNodes(TreeNode root) {
//        return countStars(root);
//    }
//    public int countStars(TreeNode node){
//        if(node==null){
//            return 0;
//        }
//        int leftedge=1;
//        int rightedge=1;
//        TreeNode left=node.left;
//        TreeNode right=node.right;
//        while(left!=null){
//            left=left.left;
//            leftedge++;
//        }
//
//        while(right!=null){
//            right=right.right;
//            rightedge++;
//        }
//        if(leftedge==rightedge){
//            return (int)(Math.pow(2,leftedge))-1;
//        }
//        return 1+countStars(node.left)+countStars(node.right);
//    }
//}


