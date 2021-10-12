package recall;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _39_combination_sum {
    class Solution {
        List<List<Integer>> res=new ArrayList();
        int sum=0;
        ArrayList<Integer> path=new ArrayList();
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            Arrays.sort(candidates);                         //排序后方便剪枝，才有18-29line
            backTracing(candidates,target,0);
            return res;
        }
        public void backTracing(int[] candidates,int target,int pos){
            if(sum==target){
                res.add(new ArrayList(path));
                return;
            }
            for(int i=pos;i<candidates.length;i++){
                if(sum+candidates[i]>target) break;            //循环内的i容易写成pos，写成pos的话第一个数一定会被纳入
                sum+=candidates[i];
                path.add(candidates[i]);
                backTracing(candidates,target,i);
                path.remove(path.size()-1);
                sum-=candidates[i];
            }
        }
    }
}
