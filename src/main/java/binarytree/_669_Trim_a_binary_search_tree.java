package binarytree;
//此题也需要重构二叉树，感觉非常复杂，但可以模仿450删除二叉树中的代码结构，通过递归函数返回节点来重构父节点的左右叶子节点，写起来非常简洁
public class _669_Trim_a_binary_search_tree {
    class Solution {
        public TreeNode trimBST(TreeNode root, int low, int high) {
            if(root==null){
                return null;
            }
            if(root.val<low){
                return trimBST(root.right,low,high);
            }else if(root.val>high){
                return trimBST(root.left,low,high);
            }else{
                root.left=trimBST(root.left,low,high);
                root.right=trimBST(root.right,low,high);
            }
            return root;
        }
    }
}
