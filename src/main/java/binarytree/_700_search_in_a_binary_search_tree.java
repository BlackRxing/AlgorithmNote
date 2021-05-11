package binarytree;

public class _700_search_in_a_binary_search_tree {
    class Solution {
        public TreeNode searchBST(TreeNode root, int val) {
            while(root!=null){
                if(root.val>val){
                    root=root.left;
                }else if(root.val<val){
                    root=root.right;
                }else{
                    return root;
                }
            }
            return root;
        }
    }
}
