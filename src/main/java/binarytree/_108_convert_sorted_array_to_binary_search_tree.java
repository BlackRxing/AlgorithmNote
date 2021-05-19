package binarytree;
//和450删除二叉树节点使用的结构类似，返回的是新构成的节点。
public class _108_convert_sorted_array_to_binary_search_tree {
    class Solution {
        public TreeNode sortedArrayToBST(int[] nums) {
            return traversal(nums,0,nums.length-1);
        }
        public TreeNode traversal(int[] nums,int low,int high){
            if(low>high){
                return null;
            }
            int mid=low+(high-low)/2;
            TreeNode node=new TreeNode(nums[mid]);
            node.left=traversal(nums,low,mid-1);
            node.right=traversal(nums,mid+1,high);
            return node;
        }
    }
}
