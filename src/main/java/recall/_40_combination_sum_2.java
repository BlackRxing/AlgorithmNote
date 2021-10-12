package recall;

import java.util.*;

public class _40_combination_sum_2 {
    class Solution {
        int sum=0;
        List<List<Integer>> res=new ArrayList();
        Deque<Integer> path=new LinkedList();

        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            Arrays.sort(candidates);
            boolean[] flag=new boolean[candidates.length];
            backtracing(candidates,target,0,flag);
            return res;
        }
        public void backtracing(int[] candidates,int target,int pos,boolean[] flag){
            if(sum==target){
                res.add(new ArrayList(path));
                return;
            }
            for(int i=pos;i<candidates.length&&candidates[i]+sum<=target;i++){
                if(i>0&&candidates[i]==candidates[i-1]&&!flag[i-1]){  //这一行是最关键的，相同的数字只能是TTTTF的形式才可以使用，否则会出现重复的情况，相同数字先用前面的
                    continue;
                }
                flag[i]=true;
                sum+=candidates[i];
                path.push(candidates[i]);
                backtracing(candidates,target,i+1,flag);  //这里是i，不是pos
                sum-=candidates[i];
                path.pop();
                flag[i]=false;
            }
        }
    }
}
