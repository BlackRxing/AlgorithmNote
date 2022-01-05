package hash;

import java.util.Map;
//此题没有捷径，只能尽量减少计算量，使用哈希表存储前后两组数据以及出现次数，之后问题转化为求两数之和为0，因为有哈希表，所以直接做减法即可
public class _454_4sum_II {
    class Solution {
        public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
            Map<Integer,Integer> map=new HashMap<>();
            int result=0;
            int temp;
            for(int i:nums1){
                for(int j:nums2){
                    temp=i+j;
                    if(map.containsKey(temp)){
                        map.put(temp,map.get(temp)+1);
                    }else{
                        map.put(temp,1);
                    }
                }
            }
            for(int p:nums3){
                for(int q:nums4){
                    temp=p+q;
                    if(map.containsKey(0-temp)){
                        result+=map.get(0-temp);
                    }
                }

            }
            return result;
        }
    }
}
