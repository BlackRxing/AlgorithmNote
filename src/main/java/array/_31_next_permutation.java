package array;
//将数组想象成折线段更容易理解
//本质上是寻找第一个下降的点，然后从最后开始找第一个超过这个点的位置，交换这两个点，最后将这个点之后的所有数字升序排列，因为原来是降序排列的，所以直接用reverse函数两两交换
public class _31_next_permutation {
    class Solution {
        public void nextPermutation(int[] nums) {
            int a=nums.length-1,b=nums.length-1,c=nums.length-2;
            while(c>=0&&nums[c]>=nums[b]){
                c--;
                b--;
            }
            if(c>=0){
                while(nums[a]<=nums[c]){
                    a--;
                }
                swap(nums,a,c);
            }
            reverse(nums,b,nums.length-1);
        }
        public void swap(int[] nums,int a,int b){
            int temp=nums[a];
            nums[a]=nums[b];
            nums[b]=temp;
        }
        public void reverse(int[] nums,int a,int b){
            while(a<b){
                swap(nums,a,b);
                a++;
                b--;
            }
        }
    }
}
