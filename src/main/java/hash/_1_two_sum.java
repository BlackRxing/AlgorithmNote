package hash;
//如果用双指针首先需要解决一个问题，即排序后的下标如何对应之前的下标
public class _1_two_sum {
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer,Integer> hashmap=new HashMap<Integer,Integer>();
            for(int i=0;i<nums.length;i++){
                if(hashmap.containsKey(target-nums[i])){
                    return new int[]{hashmap.get(target-nums[i]),i};
                }
                hashmap.put(nums[i],i);
            }
            return null;
        }
    }
}
