package binarytree;

public class _98_validate_binary_search_tree {
    class Solution {
        TreeNode pre=null;
        public boolean isValidBST(TreeNode root) {
            if(root==null){
                return true;
            }
            boolean left=isValidBST(root.left);
            if(pre!=null&&pre.val>=root.val){
                return false;
            }
            pre=root;
            boolean right=isValidBST(root.right);
            return left&&right;
        }
    }

}
