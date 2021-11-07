package greedy;
//记录每一步能够扩展的范围
public class _45_jump_game_II {
    class Solution {
        public int jump(int[] nums) {
            int l=0,r=0;  //l与r记录了每一次可以覆盖的新的范围，不包括与上一次重叠的范围
            int step=0;
            while(r<nums.length-1){
                int temp=r;
                for(int i=l;i<=temp;i++){
                    r=Math.max(r,nums[i]+i);
                }
                step++;
                l=temp+1; //防止重复多余
            }
            return step;
        }
    }
}
