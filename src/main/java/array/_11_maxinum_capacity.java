package array;
//双指针放两边，小的一边移动，可以证明不会存在反例
public class _11_maxinum_capacity {
    class Solution {
        public int maxArea(int[] height) {
            int left=0;
            int right=height.length-1;
            int result=0;
            int temp;
            while(left<right){
                temp=Math.min(height[left],height[right])*(right-left);
                result=Math.max(temp,result);
                if(height[left]>=height[right]){
                    right--;
                }else{
                    left++;
                }
            }
            return result;
        }
    }
}
