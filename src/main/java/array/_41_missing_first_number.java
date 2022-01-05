package array;

//用空间换时间，选择将【1--n】放在合适的位置，即（nums【i】=i+1），第一次遍历就记录了一些信息，第二次遍历直接得出结果
public class _41_missing_first_number {
    class Solution {
        public int firstMissingPositive(int[] nums) {
            int temp;
            for(int i=0;i<nums.length;i++){
                while(nums[i]>=1&&nums[i]<=nums.length&&nums[nums[i]-1]!=nums[i]){//这里应当是while循环
                    //这里交换的顺序不能变，如果nums[i]先被赋值会出错，因为nums[i]-1变了，可能越界
                    temp=nums[nums[i]-1];
                    nums[nums[i]-1]=nums[i];
                    nums[i]=temp;
                }
            }
            for(int i=0;i<nums.length;i++){
                if(nums[i]!=i+1){
                    return i+1;
                }
            }
            return nums.length+1;
        }
    }
}
