package recall;

import java.util.ArrayList;
import java.util.List;

public class _46_permutations {
    class Solution {
        List<Integer> path=new ArrayList();
        List<List<Integer>> res=new ArrayList();

        public List<List<Integer>> permute(int[] nums) {
            boolean[] flags=new boolean[nums.length];
            backTracking(nums,flags);
            return res;
        }
        public void backTracking(int[] nums,boolean[] flags){
            if(path.size()==nums.length){
                res.add(new ArrayList(path));
                return;
            }
            for(int i=0;i<nums.length;i++){
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
