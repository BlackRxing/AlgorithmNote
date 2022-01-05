package hash;

import java.util.HashSet;
import java.util.Set;

public class _349_intersection_of_two_arrays {
    class Solution {
        public int[] intersection(int[] nums1, int[] nums2) {
            Set<Integer> set=new HashSet();
            Set<Integer> resultSet=new HashSet();
            for(int i:nums1){
                set.add(i);
            }
            for(int j:nums2){
                if(set.contains(j)){
                    resultSet.add(j);
                }
            }
            int[] result=new int[resultSet.size()];
            int i=0;
            for(int a:resultSet){
                result[i++]=a;
            }
            return result;
        }
    }
}
