package binarytree;

public class _235_Lowest_Common_Ancestor_Of_a_binary_Search_tree {
    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if(root.val>p.val&&root.val>q.val){
                return lowestCommonAncestor(root.left,p,q);
            }else if(root.val<p.val&&root.val<q.val){
                return lowestCommonAncestor(root.right,p,q);
            }
            return root;
        }
    }
}
