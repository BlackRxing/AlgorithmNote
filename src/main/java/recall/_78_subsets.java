package recall;

import java.util.ArrayList;
import java.util.List;

public class _78_subsets {
    class Solution {
        List<List<Integer>> res=new ArrayList();
        List<Integer> path=new ArrayList();
        public List<List<Integer>> subsets(int[] nums) {
            backTracking(nums,0);
            res.add(new ArrayList());
            return res;
        }
        public void backTracking(int[] nums,int pos){
            for(int i=pos;i<nums.length;i++){
                path.add(nums[i]);    //i和pos不能混淆
                res.add(new ArrayList(path));
                backTracking(nums,i+1);
                path.remove(path.size()-1);
            }
        }
    }
}
