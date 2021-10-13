package recall;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _90_subsets_II {
    class Solution {
        List<List<Integer>> res=new ArrayList();
        List<Integer> path=new ArrayList();
        public List<List<Integer>> subsetsWithDup(int[] nums) {
            res.add(path);
            boolean[] flag=new boolean[nums.length];
            Arrays.sort(nums);
            backTracking(nums,0,flag);
            return res;
        }
        public void backTracking(int[] nums,int pos,boolean[] flag){
            for(int i=pos;i<nums.length;i++){
                if(i>0&&nums[i]==nums[i-1]&&!flag[i-1]){       //同一层如果前面出现过相同的数字，就无需使用
                    continue;
                }
                path.add(nums[i]);
                res.add(new ArrayList(path));
                flag[i]=true;
                backTracking(nums,i+1,flag);
                flag[i]=false;
                path.remove(path.size()-1);
            }
        }
    }
}
