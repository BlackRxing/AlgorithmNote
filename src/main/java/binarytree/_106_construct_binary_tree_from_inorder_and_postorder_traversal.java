package binarytree;

public class _106_construct_binary_tree_from_inorder_and_postorder_traversal {
    class Solution {
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            if(inorder==null||postorder==null){
                return null;
            }
            return recursion(inorder,postorder,0,postorder.length-1,0,postorder.length-1);
        }
        public TreeNode recursion(int[] inorder,int[] postorder,int ileft,int iright,int pleft,int pright){
            if(ileft>iright||pleft>pright){
                return null;
            }
            TreeNode node=new TreeNode();
            node.val=postorder[pright];
            if(ileft==iright){
                node.left=null;
                node.right=null;
                return node;
            }
            int midnum=node.val;
            int middle=0;
            for(int i=ileft;i<=iright;i++){
                if(inorder[i]==midnum){
                    middle=i;
                    break;
                }
            }
            node.left=recursion(inorder,postorder,ileft,middle-1,pleft,pleft+middle-ileft-1);
            node.right=recursion(inorder,postorder,middle+1,iright,pleft+middle-ileft,pright-1);
            return node;
        }
    }
}
