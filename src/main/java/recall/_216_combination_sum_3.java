package recall;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class _216_combination_sum_3 {
    class Solution {
        List<List<Integer>> result=new ArrayList<>();
        LinkedList<Integer> path=new LinkedList<>();
        public List<List<Integer>> combinationSum3(int k, int n) {
            recall(k,n,1,0);
            return result;
        }
        public void recall(int k, int n, int pos ,int sum){
            if(path.size()==k){
                if(sum==n) result.add(new ArrayList(path));  //一定要new！！！
                return;
            }
            for(int i=pos;i+sum<=n&&i<=9;i++){ //容易漏掉i《=9，第一个条件是为了剪枝
                sum+=i;
                path.add(i);
                recall(k,n,i+1,sum);
                path.removeLast();
                sum-=i;
            }
        }
    }
}
