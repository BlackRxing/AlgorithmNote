package binary_search;

//首先将问题转化为求最k小的数字，分为两种情况，长度之和是奇数或者偶数
//和二分法有异曲同工之妙，将k分为两部分，如果有一方的k/2小于另一方，则完全抛弃这k/2个数字
public class _4_median_of_two_sorted_arrays {
    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int length1=nums1.length;
            int length2=nums2.length;
            int length=length1+length2;
            if((length)%2==0){
                return (findKSmallest(nums1,nums2,length/2)+findKSmallest(nums1,nums2,length/2+1))/2;
            }else{
                return findKSmallest(nums1,nums2,length/2+1);
            }
        }
        public double findKSmallest(int[] nums1,int[] nums2,int k){
            int pos1=0,pos2=0;
            while(true){
                if(pos1==nums1.length){        //一个数组已经到达边界
                    return nums2[pos2+k-1];
                }
                if(pos2==nums2.length){
                    return nums1[pos1+k-1];
                }
                if(k==1){                      //当k=2时，还可以更新，k=1时pos会倒退，这一行要卸载后面，否则会出现数组越界
                    return(Math.min(nums1[pos1],nums2[pos2]));
                }
                int newpos1=Math.min(nums1.length-1,pos1+k/2-1);  //防止越界，后续只要更新k的值即可
                int newpos2=Math.min(nums2.length-1,pos2+k/2-1);
                if(nums1[newpos1]<=nums2[newpos2]){
                    k=k-(newpos1-pos1+1);                       //更新k的值
                    pos1=newpos1+1;
                }else if(nums1[newpos1]>=nums2[newpos2]){
                    k=k-(newpos2-pos2+1);
                    pos2=newpos2+1;
                }else{                                 //如果相等说明已经找到第k小的值了
                    return nums1[newpos1];
                }
            }
        }
    }
}
