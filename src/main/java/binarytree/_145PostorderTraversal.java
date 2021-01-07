package binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution3 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List result=new ArrayList();
        Stack<TreeNode> stack=new Stack();
        while(root!=null||(!stack.empty())){
            if(root!=null){
                result.add(0,root.val);
                stack.push(root);
                root=root.right;
            }else{
                root=stack.pop().left;
            }
        }
        return result;
    }
}
