package binarytree;
//先序遍历，使用递归，保存深度
//深度遍历最直接
//https://leetcode-cn.com/problems/find-bottom-left-tree-value/
public class _513_find_bottom_left_tree_value {
    class Solution {
        public int ans;
        public int maxDepth=0;
        public int findBottomLeftValue(TreeNode root) {
            if(root==null){
                return 0;
            }
            findValue(root,1);
            return ans;
        }
        public void findValue(TreeNode node,int depth){
            if(depth>maxDepth&&node.left==null&&node.right==null){
                maxDepth=depth;
                ans=node.val;
                return;
            }
            if(node.left!=null){
                findValue(node.left,depth+1);
            }
            if(node.right!=null){
                findValue(node.right,depth+1);
            }
        }
    }
}

