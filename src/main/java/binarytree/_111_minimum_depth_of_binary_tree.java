package binarytree;

import java.util.LinkedList;
import java.util.Queue;
//迭代，queue层次遍历，最小深度是根节点到叶节点的最小距离，必须是左右两个节点都是null才能称为叶子节点
//public class _111_minimum_depth_of_binary_tree {
//    class Solution {
//        public int minDepth(TreeNode root) {
//            return findminDepth(root);
//        }
//        public int findminDepth(TreeNode node){
//            if(node==null){
//                return 0;
//            }
//            if(node.left!=null&&node.right==null){
//                return 1+minDepth(node.left);
//            }
//            if(node.left==null&&node.right!=null){
//                return 1+minDepth(node.right);
//            }
//            return 1+Math.min(minDepth(node.left),minDepth(node.right));
//        }
//    }
//}
class Solution2 {
    public int minDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        int mindepth=0;
        int length=1;
        Queue<TreeNode> queue=new LinkedList();
        queue.offer(root);
        while(!queue.isEmpty()){
            mindepth++;
            length=queue.size();
            for(int i=0;i<length;i++){
                TreeNode node=queue.poll();
                if(node.left!=null){
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                }
                if(node.left==null&&node.right==null){
                    return mindepth;
                }
            }
        }
        return mindepth;
    }
}
