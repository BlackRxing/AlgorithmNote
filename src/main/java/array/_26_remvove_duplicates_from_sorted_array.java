package array;

public class _26_remvove_duplicates_from_sorted_array {
    class Solution {
        public int removeDuplicates(int[] nums) {
            int fast=0,slow=0;
            while(fast<nums.length){
                if(nums[fast]==nums[slow]){
                    fast++;
                }else{
                    slow++;
                    nums[slow]=nums[fast];
                    fast++;
                }
            }
            return slow+1;
        }
    }
}
