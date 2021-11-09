package greedy;

import javax.swing.tree.TreeNode;
//贪心算法，后序遍历
public class _968_binary_tree_cameras {
    class Solution {
        public int count=0;
        public int minCameraCover(TreeNode root) {
            if(traversal(root)==0){ //这一步容易漏掉
                count++;
            }
            return count;
        }
        public int traversal(TreeNode root){
            if(root==null){      //null为有覆盖，这样就不用考虑该节点了
                return 2;
            }
            int left=traversal(root.left);
            int right=traversal(root.right);
            if(left==2&&right==2){
                return 0;
            }
            if(left==0||right==0){  //一定要先写这一行，有一个无覆盖都要设立摄像头
                count++;
                return 1;
            }
            if(left==1||right==1){
                return 2;
            }
            return -1;
        }
    }
}
