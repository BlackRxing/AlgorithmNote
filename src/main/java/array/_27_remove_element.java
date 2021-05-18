package array;
//快慢指针求解，注意不要想交换元素，把目标元素交换到数组尾部，目标元素不需要保留
public class _27_remove_element {
    class Solution {
        public int removeElement(int[] nums, int val) {
            int fast=0,slow=0;
            while(fast<nums.length){
                if(nums[fast]==val){
                    fast++;
                }else{
                    nums[slow]=nums[fast];
                    fast++;
                    slow++;
                }
            }
            return slow;
        }
    }
}
