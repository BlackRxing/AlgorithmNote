package greedy;

import java.util.Arrays;
//贪心算法
public class _455_assign_cookies {
    class Solution {
        public int findContentChildren(int[] g, int[] s) {
            Arrays.sort(g);
            Arrays.sort(s);
            int j=g.length-1;
            int i=s.length-1;
            int count=0;
            while(i>=0&&j>=0){
                if(s[i]>=g[j]){
                    count++;
                    i--;
                }
                j--;
            }
            return count;
        }
    }
}
