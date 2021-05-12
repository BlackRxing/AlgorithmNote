package binarytree;
//二叉树中的null也当成节点的话，每两个元素中间都有一个null，再加上头尾的null，可以将插入数值直接替换null，使用二叉树搜索
//本题不适合中序便利，因为需要考虑判断第一个大于val的节点，或者最后一个小于val的节点，情况比较复杂！！！
public class _701_Insert_into_a_binary_search_tree {
    class Solution {
        TreeNode pre=null;
        public TreeNode insertIntoBST(TreeNode root, int val) {
            if(root==null){
                return new TreeNode(val);
            }
            traverse(root,val);
            return root;
        }
        public void traverse(TreeNode root,int val){
            if(root==null){
                if(pre.val>val){
                    pre.left=new TreeNode(val);
                }else{
                    pre.right=new TreeNode(val);
                }
                return;
            }
            pre=root;
            if(val>root.val){
                traverse(root.right,val);
            }else {
                traverse(root.left, val);
            }
        }
    }
}
