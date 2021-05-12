package binarytree;

import java.util.Stack;


//可以用层次遍历，深度遍历（先序以及后序），中序遍历不可以，因为左中右之后，左节点其实被调换两遍！！！
public class _226_Invert_binary_tree {
    class Solution {
        public TreeNode invertTree(TreeNode root) {
            if(root==null){
                return root;
            }
            Stack<TreeNode> stack=new Stack();
            stack.push(root);
            while(!stack.isEmpty()){
                TreeNode cur=stack.pop();
                if(cur==null){
                    TreeNode node=stack.pop();
                    TreeNode var=node.left;
                    node.left=node.right;
                    node.right=var;
                }else{
                    if(cur.right!=null){
                        stack.push(cur.right);
                    }
                    if(cur.left!=null){
                        stack.push(cur.left);
                    }
                    stack.push(cur);
                    stack.push(null);
                }
            }
            return root;
        }
    }
}
