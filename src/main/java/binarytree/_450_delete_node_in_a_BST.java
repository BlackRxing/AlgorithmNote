package binarytree;
//使用递归，外层是查找，返回下一个查找节点的值
//内层处理逻辑：如果左右有一个是null，返回另一个，如果都不为null，将左节点放到右节点最左下节点（即最小的位置），然后返回右节点
public class _450_delete_node_in_a_BST {
    class Solution {
        public TreeNode deleteNode(TreeNode root, int key) {
            if(root==null){
                return root;
            }
            if(root.val==key){
                if(root.left==null){
                    return root.right;
                }else if(root.right==null){
                    return root.left;
                }else{
                    TreeNode cur=root.right;
                    while(cur.left!=null){
                        cur=cur.left;
                    }
                    cur.left=root.left;
                    return root.right;
                }
            }else if(root.val<key){
                root.right=deleteNode(root.right,key);
            }else{
                root.left=deleteNode(root.left,key);
            }
            return root;
        }
    }
}
