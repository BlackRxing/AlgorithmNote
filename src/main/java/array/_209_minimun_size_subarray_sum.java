package array;
//使用滑动窗口
public class _209_minimun_size_subarray_sum {
    class Solution {
        public int minSubArrayLen(int target, int[] nums) {
            int a=0,b=0,s=nums[0],min=Integer.MAX_VALUE;
            while(true){
                if(s>=target){
                    min=Math.min(min,b-a+1);
                    if(a<b){
                        s-=nums[a++];
                    }else if(b==nums.length-1){ //如果a=b,这个时候要移动b，但是注意b可能已经到达了边界
                        break;
                    }else{
                        s+=nums[++b];
                    }
                }else{
                    if(b==nums.length-1){  //b到达边界
                        break;
                    }else{
                        s+=nums[++b];
                    }
                }
            }
            return min==Integer.MAX_VALUE?0:min;
        }
    }
}
