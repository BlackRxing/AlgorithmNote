package binarytree;

import java.util.*;

public class _107_Binary_Tree_Level_Order_Traversal_II {
    class Solution {
        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            List<List<Integer>> ans=new ArrayList();
            Queue<TreeNode> queue=new LinkedList();
            if(root==null){
                return ans;
            }
            queue.offer(root);
            while(!queue.isEmpty()){
                List<Integer> list=new LinkedList();
                int size=queue.size();
                for(int i=0;i<size;i++){
                    TreeNode node=queue.poll();
                    list.add(node.val);
                    if(node.left!=null){
                        queue.offer(node.left);
                    }
                    if(node.right!=null){
                        queue.offer(node.right);
                    }
                }
                ans.add(list);
            }
            Collections.reverse(ans);
            return ans;
        }
    }
}
