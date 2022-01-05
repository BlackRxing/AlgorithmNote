package other;

import javax.management.relation.Relation;

public class _277_find_the_celebrity {
    /* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */
//时间复杂度为3*n
    public class Solution extends Relation {
        public int findCelebrity(int n) {
            int ans=0;
            for(int i=1;i<n;i++){  //首先搜索出唯一可能的答案，因为大于ans的都被ans都不认识（有一个其他不认识都算），小于ans的都认识ans（认识其他任何一个的都不算）
                if(knows(ans,i)){
                    ans=i;
                }
            }
            for(int i=0;i<n;i++){
                if(i!=ans){
                    if(knows(ans,i)){
                        return -1;
                    }
                    if(!knows(i,ans)){
                        return -1;
                    }
                }
            }
            return ans;
        }
    }
}
