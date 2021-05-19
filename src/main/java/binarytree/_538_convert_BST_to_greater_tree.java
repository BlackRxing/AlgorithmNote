package binarytree;
//使用逆向中序便利！！！
public class _538_convert_BST_to_greater_tree {
    class Solution {
        public int sum=0;
        public TreeNode convertBST(TreeNode root) {
            if(root==null){
                return null;
            }
            convertBST(root.right);
            root.val=root.val+sum;
            sum=root.val;
            convertBST(root.left);
            return root;
        }
    }
}
