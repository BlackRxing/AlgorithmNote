package binary_search;

class Solution {
    public int searchInsert(int[] nums, int target) {
        int left=0;
        int length=nums.length;
        int right=length-1;
        if(nums[length-1]<target){
            return length;
        }
        while(left<right){
            int mid=left+(right-left)/2;
            if(nums[mid]<target){
                left=mid+1;
            }else if(nums[mid]>target){
                right=mid;
            }else{
                return mid;
            }
        }
        return left;
    }
}