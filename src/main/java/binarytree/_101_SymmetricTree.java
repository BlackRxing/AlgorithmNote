package binarytree;

import java.util.Stack;
//其实要求左右子树对称，用遍历的方法即可
//可以用层次遍历，也可以用深度遍历：递归，或stack中左右|中右左迭代
public class _101_SymmetricTree {
    class Solution {
        public boolean isSymmetric(TreeNode root) {
            if(root==null){
                return true;
            }
            Stack<TreeNode> stack=new Stack();
            stack.push(root.left);
            stack.push(root.right);
            while(!stack.isEmpty()){
                TreeNode left=stack.pop();
                TreeNode right=stack.pop();
                if(left==null||right==null){
                    if(left==null&&right==null){
                        continue;
                    }
                    return false;
                }
                if(left.val!=right.val){
                    return false;
                }
                stack.push(left.left);
                stack.push(right.right);
                stack.push(left.right);
                stack.push(right.left);
            }
            return true;
        }
    }
}
