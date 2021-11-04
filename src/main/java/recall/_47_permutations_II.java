package recall;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _47_permutations_II {
    class Solution {
        List<Integer> path=new ArrayList();
        List<List<Integer>> res=new ArrayList();
        public List<List<Integer>> permuteUnique(int[] nums) {
            boolean[] flags=new boolean[nums.length];
            Arrays.sort(nums);
            backTracking(nums,flags);
            return res;
        }
        public void backTracking(int[] nums,boolean[] flags){
            if(path.size()==nums.length){
                res.add(new ArrayList(path));
                return;
            }
            for(int i=0;i<nums.length;i++){
                if(i>0&&nums[i]==nums[i-1]&&!flags[i-1]){  //这一步是关键，如果i-1为true说明i-1在上一层，如果是false说明i-1在同一层
                    continue;
                }
                if(flags[i]){
                    continue;
                }
                path.add(nums[i]);
                flags[i]=true;
                backTracking(nums,flags);
                path.remove(path.size()-1);
                flags[i]=false;
            }
        }
    }
}
