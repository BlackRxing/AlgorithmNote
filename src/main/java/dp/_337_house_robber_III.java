package dp;

import javax.swing.tree.TreeNode;

public class _337_house_robber_III {
    //重复性较大,越往下的子节点被重复计算的次数越多
    public int rob(TreeNode root) {
        if (root == null)
            return 0;
        int money = root.val;
        if (root.left != null) {
            money += rob(root.left.left) + rob(root.left.right);
        }
        if (root.right != null) {
            money += rob(root.right.left) + rob(root.right.right);
        }
        return Math.max(money, rob(root.left) + rob(root.right));
    }
    //只用到子节点，无需子子节点，每个点只遍历一次
    class Solution {
        public int rob(TreeNode root) {
            int[] res;
            res=traversal(root);
            return Math.max(res[0],res[1]);
        }
        public int[] traversal(TreeNode node){
            int[] res=new int[2];
            if(node==null){
                return res;
            }
            int val0,val1;
            int[] left,right;
            left=traversal(node.left);
            right=traversal(node.right);
            val0=Math.max(left[0],left[1])+Math.max(right[0],right[1]);
            val1=node.val+left[0]+right[0];
            res[0]=val0;
            res[1]=val1;
            return res;
        }
    }
}
