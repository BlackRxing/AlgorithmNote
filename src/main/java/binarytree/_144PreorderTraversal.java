package binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution1 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList();
        TreeNode cur=root;
        Stack<TreeNode> stack=new Stack();
        while(!stack.isEmpty()||cur!=null){
            if(cur!=null){
                list.add(cur.val);
                if(cur.right!=null){
                    stack.push(cur.right);
                }
                cur=cur.left;
            }else{
                cur=stack.pop();
            }
        }
        return list;
    }
}
