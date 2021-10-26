package dp;

import java.util.List;
//动态规划思想
public class _139_word_break {
    class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            boolean[] dp=new boolean[s.length()+1];
            dp[0]=true;
            for(int i=1;i<=s.length();i++){
                for(int j=1;j<=i;j++){
                    if(wordDict.contains(s.substring(j-1,i))&&dp[j-1]){
                        dp[i]=true;
                    }
                }
            }
            return dp[s.length()];
        }
    }
}
