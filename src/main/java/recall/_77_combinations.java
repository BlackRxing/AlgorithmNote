package recall;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
public class _77_combinations {
    class Solution {
        List<List<Integer>> result=new ArrayList<>();
        LinkedList<Integer> path=new LinkedList<>();
        public List<List<Integer>> combine(int n, int k) {
            combine(n,k,1);
            return result;
        }
        public void combine(int n, int k, int pos){
            if(path.size()==k){
                result.add(new ArrayList<>(path));   //这一步老是忘记
                return;
            }
            for(int i=pos;i<=path.size()+n-k+1;i++){  //剪枝提高效率，当n=4，k=4时，比如第一层遍历到2 3 4就没有必要了，长度不够
                path.add(i);
                combine(n,k,i+1);
                path.remove(path.size()-1);
            }
        }
    }
}
