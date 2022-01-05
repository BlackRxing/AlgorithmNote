package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//本题的难点在于结果不能重复，使用双指针算法，复杂度降低为n^2
public class _15_3sum {
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);  //首先记得排序
            List<List<Integer>> ans=new ArrayList();
            for(int i=0;i<nums.length-2;i++){  //防止第一个数重复
                if(i>0&&nums[i]==nums[i-1]){
                    continue;
                }
                int left=i+1;
                int right=nums.length-1;
                while(left<right){
                    int sum=nums[left]+nums[i]+nums[right];
                    if(sum<0){
                        left++;
                    }else if(sum>0){
                        right--;
                    }else{  //接下来的部分本质就是快速找两个数之和的搭配
                        ans.add(Arrays.asList(nums[i],nums[left],nums[right]));
                        while(left<right&&nums[left]==nums[left+1]){  //防止第2,3个数重复
                            left++;
                        }
                        while(left<right&&nums[right]==nums[right-1]){
                            right--;
                        }
                        left++;
                        right--;
                    }
                }
            }
            return ans;
        }
    }
}
