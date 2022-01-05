package sort;

import java.util.ArrayList;
import java.util.List;
//算是OFFER51的升级版，通过记录元素的下标，既可以访问元素本身，也能记录该元素对应的result
//与51不同的是mergesort里的判断，如果想要达到nlogn只能针对每一个left区域的元素进行累加
public class _315_count_of_smaller_numbers_after_self {
    class Solution {
        public List<Integer> countSmaller(int[] nums) {
            int length=nums.length;
            if(length==0){
                return null;
            }
            int left=0,right=length-1;
            int[] temp=new int[length];
            int[] results=new int[length];
            int[] indexs=new int[length];
            for(int i=left;i<=right;i++){
                indexs[i]=i;
            }
            recursion(nums,indexs,temp,left,right,results);
            List<Integer> result=new ArrayList<Integer>();
            for(int i:results){
                result.add(i);
            }
            return result;
        }
        private void recursion(int[] nums,int[] indexs,int[] temp,int left,int right,int[] results){
            if(left==right){
                return;
            }
            int mid=left+(right-left)/2;
            recursion(nums,indexs,temp,left,mid,results);
            recursion(nums,indexs,temp,mid+1,right,results);
            mergeSort(nums,indexs,temp,left,right,mid,results);
        }
        private void mergeSort(int[] nums,int[] indexs,int[] temp,int left,int right,int mid,int[] results){
            for (int i = left; i <= right; i++) {
                temp[i] = indexs[i];
            }
            int i=left;
            int j=mid+1;
            int ans=0;
            for(int y=left;y<=right;y++){
                if(i==mid+1){
                    indexs[y]=temp[j];
                    j++;
                }else if(j==right+1){
                    indexs[y]=temp[i];
                    results[temp[i]]+=right-mid; //这一行非常容易漏掉
                    i++;
                }else if(nums[temp[i]]<=nums[temp[j]]){
                    indexs[y]=temp[i];
                    results[temp[i]]+=j-mid-1;  //容易错
                    i++;
                }else{
                    indexs[y]=temp[j];
                    j++;
                }
            }
        }
    }
}
