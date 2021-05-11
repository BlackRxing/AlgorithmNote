package binarytree;

public class _530_minimun_absolute_difference_in_BTS {
    class Solution {
        public int result=Integer.MAX_VALUE;
        TreeNode pre=null;
        public int getMinimumDifference(TreeNode root) {
            traversal(root);
            return result;
        }
        public void traversal(TreeNode root){
            if(root==null){
                return;
            }
            traversal(root.left);
            if(pre!=null&&(root.val-pre.val)<result){
                result=root.val-pre.val;
            }
            pre=root;
            traversal(root.right);
            return;
        }
    }
}
