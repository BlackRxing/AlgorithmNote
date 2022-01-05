package binarytree;
//采用后续遍历
public class _124_binary_tree_maxinum_path_sum {
    class Solution {
        int result=Integer.MIN_VALUE;
        public int maxPathSum(TreeNode root) {
            traversal(root);
            return result;
        }
        public int traversal(TreeNode root){
            if(root==null) return 0;
            int left=traversal(root.left);
            int right=traversal(root.right);
            result=Math.max(result,left+right+root.val);   //包括该点，链路向左右两边延伸的情况
            return Math.max(Math.max(left,right)+root.val,0);//可能包括该点，能够向父节点提供的最大值,返回值一定大于等于0
        }
    }
}
