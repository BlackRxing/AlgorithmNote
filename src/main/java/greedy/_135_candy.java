package greedy;

import java.util.Arrays;
//正向遍历保持局部右边大，反向遍历保证局部左边大于右边以及左边大于更左边（即中间最大）
public class _135_candy {
    class Solution {
        public int candy(int[] ratings) {
            int length=ratings.length;
            int[] res=new int[length];
            int ans=0;
            Arrays.fill(res,1);
            for(int i=0;i<length-1;i++){
                if(ratings[i]<ratings[i+1]){
                    res[i+1]=res[i]+1;
                }
            }
            for(int j=length-1;j>=1;j--){
                if(ratings[j-1]>ratings[j]){
                    res[j-1]=Math.max(res[j-1],res[j]+1);
                }
            }
            for(int temp:res){
                ans+=temp;
            }
            return ans;
        }
    }
}
