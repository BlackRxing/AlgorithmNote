package divide_and_conquer;
//采用分治算法，首先统计每个字符出现次数，如果不满足要求则按此字符进行分割（凡是包含此字符的字段都不满足条件），依次进行遍历，时间复杂度为26*n
public class _395_longest_substring_with_at_least_k_repeating_characters {
    class Solution {
        public int longestSubstring(String s, int k) {
            int length=s.length();
            return dfs(s,0,length-1,k);
        }
        private int dfs(String s,int left,int right,int k){
            int[] temp=new int[26];
            for(int i=left;i<=right;i++){
                temp[s.charAt(i)-'a']++;
            }
            char mark=0;
            for(int i=0;i<26;i++){
                if(temp[i]<k&&temp[i]>0){  //这里非常容易错，temp[i]<k是错误的，必须是1~k-1
                    mark=(char)('a'+i);
                    break;
                }
            }
            if(mark==0){ //写的时候容易漏掉这一行
                return right-left+1;
            }
            int pos=left;
            int l=0,r=0;
            int result=0;
            while(pos<=right){
                while(pos<=right&&s.charAt(pos)==mark){   //注意，这里是找到第一个不等于mark的字符
                    pos++;
                }
                if(pos>right){       //越界则推出
                    break;
                }
                l=pos;                 //确定左边界
                while(pos<=right&&s.charAt(pos)!=mark){  //这里是找到第一个等于mark的字符
                    pos++;
                }
                if(pos>right){                        //可能越界也可能找到了
                    r=right;
                }else{
                    r=pos-1;                           //确定右边界
                }
                result=Math.max(dfs(s,l,r,k),result);
            }
            return result;
        }
    }
}
