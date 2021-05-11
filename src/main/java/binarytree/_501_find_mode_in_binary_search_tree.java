package binarytree;

import java.util.ArrayList;

public class _501_find_mode_in_binary_search_tree {
    class Solution {
        int count=0,maxcount=0;
        TreeNode pre=null;
        ArrayList<Integer> list=new ArrayList<Integer>();
        public int[] findMode(TreeNode root) {
            traversal(root);
            int[] ans=new int[list.size()];
            for(int i=0;i<list.size();i++){
                ans[i]=list.get(i);
            }
            return ans;
        }
        public void traversal(TreeNode root){
            if(root==null){
                return;
            }
            traversal(root.left);
            if(pre==null||pre.val!=root.val){
                count=1;
            }else{
                count++;
            }
            if(count==maxcount){
                list.add(root.val);
            }
            if(count>maxcount){
                maxcount=count;
                list.clear();
                list.add(root.val);
            }

            pre=root;
            traversal(root.right);
            return;
        }
    }
}

