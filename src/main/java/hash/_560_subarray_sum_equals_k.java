package hash;

import java.util.HashMap;
import java.util.Map;
//此题如果不是有负数，可以用滑动窗口做，很简单
//hashmap用来储存key（之前出现过的总和） ，value：这个总和出现的次数
//使用当前的总和减去目标值然后直接查找出现过的总和次数
public class _560_subarray_sum_equals_k {
    class Solution {
        public int subarraySum(int[] nums, int k) {
            Map<Integer,Integer> map=new HashMap<Integer,Integer>();
            map.put(0,1); //没有任何元素时的总和
            int pre=0,result=0;
            for(int i:nums){
                pre+=i;
                result+=map.getOrDefault(pre-k,0);
                map.put(pre,map.getOrDefault(pre,0)+1); //这样写一步到位，不用if else
            }
            return result;
        }
    }
}
