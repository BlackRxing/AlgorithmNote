package array;
//双指正yysd！
public class _977_squares_of_a_sorted_array {
    class Solution {
        public int[] sortedSquares(int[] nums) {
            int s=0,t=nums.length-1,pos=t;
            int[] ans=new int[nums.length];
            while(s<=t){
                if(s==t){
                    ans[pos]=nums[s]*nums[s];
                    break;
                }
                int x=Math.abs(nums[s]);
                int y=Math.abs(nums[t]);
                if(x<y){
                    ans[pos--]=y*y;
                    t--;
                }else if(x>y){
                    ans[pos--]=x*x;
                    s++;
                }else{
                    ans[pos--]=x*x;
                    ans[pos--]=x*x;
                    s++;
                    t--;
                }
            }
            return ans;
        }
    }
}
