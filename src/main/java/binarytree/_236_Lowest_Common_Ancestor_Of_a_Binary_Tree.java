package binarytree;

public class _236_Lowest_Common_Ancestor_Of_a_Binary_Tree {
    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if(root==p||root==q||root==null){
                return root;
            }
            TreeNode left=lowestCommonAncestor(root.left,p,q);
            TreeNode right=lowestCommonAncestor(root.right,p,q);
            if(left!=null&&right!=null){
                return root;
            }else if(left!=null){
                return left;
            }else if(right!=null){
                return right;
            }
            return null;
        }
    }
}

