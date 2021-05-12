package binarytree;

//求深度用递归先序遍历，求高度用递归后序遍历
public class _110_balanced_binary_tree {
    class Solution {
        public boolean isBalanced(TreeNode root) {
            return isbanlanced(root)==-1?false:true;
        }
        public int isbanlanced(TreeNode node){
            if(node==null){
                return 0;
            }
            int left=isbanlanced(node.left);
            int right=isbanlanced(node.right);
            if(left==-1){
                return -1;
            }
            if(right==-1){
                return -1;
            }
            return Math.abs(left-right)>1?-1:1+Math.max(left,right);
        }
    }
}
