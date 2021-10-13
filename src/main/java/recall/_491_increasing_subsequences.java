package recall;

import java.util.ArrayList;
import java.util.List;

public class _491_increasing_subsequences {
    class Solution {
        List<List<Integer>> res=new ArrayList();
        List<Integer> path=new ArrayList();
        boolean skip;
        public List<List<Integer>> findSubsequences(int[] nums) {
            boolean[] flag=new boolean[nums.length];                   //与90不同的是不能进行排序，找到原来存在的递增关系
            backTracking(nums,0,flag);
            return res;
        }
        public void backTracking(int[] nums,int pos,boolean[] flag){
            for(int i=pos;i<nums.length;i++){
                for(int j=pos;j<i;j++){                        //每一层之前有用过的相同数字都跳过
                    if(nums[j]==nums[i]&&!flag[i]){
                        skip=true;
                    }
                }
                if(skip){
                    skip=false;
                    continue;
                }
                if(!path.isEmpty()&&nums[i]<path.get(path.size()-1)){
                    continue;
                }
                path.add(nums[i]);
                if(path.size()>1){
                    res.add(new ArrayList(path));
                }

                flag[i]=true;
                backTracking(nums,i+1,flag);
                flag[i]=false;
                path.remove(path.size()-1);
            }
        }
    }


}
