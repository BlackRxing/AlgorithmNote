package binarytree;

public class _654_maximun_binary_tree {
    class Solution {
        public TreeNode constructMaximumBinaryTree(int[] nums) {
            if(nums==null){
                return null;
            }
            return recursion(nums,0,nums.length-1);
        }
        public TreeNode recursion(int[] nums,int left,int right){
            if(left>right){
                return null;
            }
            TreeNode node=new TreeNode();
            if(left==right){
                node.val=nums[left];
                node.left=null;
                node.right=null;
            }
            int maxnum=-1;
            int maxpos=-1;
            for(int i=left;i<=right;i++){
                if(nums[i]>maxnum){
                    maxpos=i;
                    maxnum=nums[i];
                }
            }
            node.val=maxnum;
            node.left=recursion(nums,left,maxpos-1);
            node.right=recursion(nums,maxpos+1,right);
            return node;
        }
    }
}
