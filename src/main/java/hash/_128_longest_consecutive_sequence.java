package hash;

import java.util.HashSet;
import java.util.Set;
//使用set数据集合，空间换时间，问题在于如何去除冗余 34567   4567 567 存在冗余，通过判断是否存在i-1确定起始点去除冗余
public class _128_longest_consecutive_sequence {
    class Solution {
        public int longestConsecutive(int[] nums) {
            Set<Integer> set=new HashSet();
            int result=0;
            int length=0;
            for(int i:nums){
                set.add(i);
            }
            for(int i:nums){
                if(!set.contains(i-1)){
                    length=1;
                    while(set.contains(i+1)){
                        length++;
                        i++;
                    }
                    result=Math.max(result,length);
                }
            }
            return result;
        }
    }
}
