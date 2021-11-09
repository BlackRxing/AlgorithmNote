package greedy;

import java.util.List;
//重点是记录最远位置
public class _763_partition_labels {
    class Solution {
        public List<Integer> partitionLabels(String s) {
            int[] res=new int[26];
            for(int i=0;i<s.length();i++){
                res[s.charAt(i)-'a']=i;
            }
            List<Integer> ans=new ArrayList<>();
            int left=0;
            int edge=0;
            for(int i=0;i<s.length();i++){
                edge=Math.max(edge,res[s.charAt(i)-'a']);
                if(edge==i){
                    ans.add(edge-left+1);
                    left=i+1;
                }
            }
            return ans;
        }
    }
}
