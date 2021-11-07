package greedy;
//贪心算法，局部最优即整体最优
public class _376_wiggle_subsequence {
    class Solution {  //flag=0表示初始状态，flag=1表示上升期，flag=2表示下降期
        public int wiggleMaxLength(int[] nums) {
            int flag=0;
            int ans=1;
            for(int i=1;i<nums.length;i++){
                if(nums[i]>nums[i-1]&&(flag==0||flag==2)){
                    flag=1;
                    ans++;
                }
                if(nums[i]<nums[i-1]&&(flag==1||flag==0)){
                    flag=2;
                    ans++;
                }
            }
            return ans;
        }
    }
}
