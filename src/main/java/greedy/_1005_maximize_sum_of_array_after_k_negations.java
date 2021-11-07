package greedy;

import java.util.Arrays;

public class _1005_maximize_sum_of_array_after_k_negations {
    class Solution {
        public int largestSumAfterKNegations(int[] nums, int k) {
            Arrays.sort(nums);
            int pos=0;
            int sum=0;
            while(pos<nums.length&&nums[pos]<0&&k>0){ //注意范围
                sum=sum-nums[pos];
                pos++;
                k--;
            }
            if(k==0||k%2==0){     //如果k用完或k是偶数
                for(int i=pos;i<nums.length;i++){
                    sum+=nums[i];
                }
                return sum;
            }
            if(pos==nums.length){ //k是奇数，pos超出范围
                sum=sum+2*nums[pos-1];
                return sum;
            }
            if(pos==0||(-nums[pos-1]>nums[pos])){ //k是奇数，pos比pos-1还小
                sum-=nums[pos];
                for(int i=pos+1;i<nums.length;i++){
                    sum+=nums[i];
                }
            }else{           //pos比pos-1大，要加上两个pos-1
                sum=sum+2*nums[pos-1];
                for(int i=pos;i<nums.length;i++){
                    sum+=nums[i];
                }
            }
            return sum;
        }
    }
}
