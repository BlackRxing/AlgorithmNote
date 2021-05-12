package binarytree;

//特别注意2^n-1中n的取值，容易漏1
public class _222_count_complete_tree_nodes {
    class Solution {
        public int countNodes(TreeNode root) {
            return countStars(root);
        }
        public int countStars(TreeNode node){
            if(node==null){
                return 0;
            }
            int leftedge=0;
            int rightedge=0;
            TreeNode left=node.left;
            TreeNode right=node.right;
            while(left!=null){
                left=left.left;
                leftedge++;
            }
            while(right!=null){
                right=right.right;
                rightedge++;
            }
            if(leftedge==rightedge){
                return (2<<leftedge)-1;
            }
            return 1+countStars(node.left)+countStars(node.right);
        }
    }
}
//class Solution {
//    public int countNodes(TreeNode root) {
//        return countStars(root);
//    }
//    public int countStars(TreeNode node){
//        if(node==null){
//            return 0;
//        }
//        int leftedge=1;
//        int rightedge=1;
//        TreeNode left=node.left;
//        TreeNode right=node.right;
//        while(left!=null){
//            left=left.left;
//            leftedge++;
//        }
//
//        while(right!=null){
//            right=right.right;
//            rightedge++;
//        }
//        if(leftedge==rightedge){
//            return (int)(Math.pow(2,leftedge))-1;
//        }
//        return 1+countStars(node.left)+countStars(node.right);
//    }
//}