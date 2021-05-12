package binarytree;

import java.util.ArrayList;
import java.util.List;
//广度遍历和递归都比较好写，注意list参数的传递，
public class _113_Path_sum_II {
    class Solution {
        List<List<Integer>> ans=new ArrayList();
        int target;
        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            List<Integer> curlist=new ArrayList();
            target=targetSum;
            dfs(root,curlist,0);
            return ans;
        }
        public void dfs(TreeNode node,List<Integer> curlist,int sum){
            if(node==null){
                return;
            }
            if(node.left==null&&node.right==null&&sum+node.val==target){
                curlist.add(node.val);
                ans.add(new ArrayList<>(curlist)); //list是引用变量，内容是连续变化的
                curlist.remove(curlist.size()-1);
                return;
            }
            curlist.add(node.val);  //添加过之后要删除！！
            dfs(node.left,curlist,sum+node.val);
            dfs(node.right,curlist,sum+node.val);
            curlist.remove(curlist.size()-1); //删除！！
            return;
        }
    }
}
