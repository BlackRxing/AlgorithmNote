package sort;
//在归并排序的过程中计算出个数，而归并排序的时间复杂度是nlogn
public class _Offer51_ {
    class Solution {
        public int reversePairs(int[] nums) {
            int length=nums.length;
            if(length<=1){
                return 0;
            }
            int left=0,right=length-1;
            int[] temp=new int[length];
            int result=recursion(nums,temp,left,right);
            return result;
        }
        private int recursion(int[] nums,int[] temp,int left,int right){
            if(left==right){
                return 0;
            }
            int mid=left+(right-left)/2;
            int leftpart=recursion(nums,temp,left,mid);
            int rightpart=recursion(nums,temp,mid+1,right);
            int merge=mergeSort(nums,temp,left,right,mid);
            return leftpart+rightpart+merge;
        }
        private int mergeSort(int[] nums,int[] temp,int left,int right,int mid){
            for (int i = left; i <= right; i++) {
                temp[i] = nums[i];
            }
            int i=left;
            int j=mid+1;
            int ans=0;
            for(int y=left;y<=right;y++){
                if(i==mid+1){  //不是mid
                    nums[y]=temp[j];
                    j++;
                }else if(j==right+1){  //一定要注意不是right
                    nums[y]=temp[i];
                    i++;
                }else if(temp[i]<=temp[j]){  //很容易写成nums
                    nums[y]=temp[i];
                    i++;
                }else{
                    nums[y]=temp[j];
                    j++;
                    ans+=mid-i+1;
                }
            }
            return ans;
        }
    }
}
