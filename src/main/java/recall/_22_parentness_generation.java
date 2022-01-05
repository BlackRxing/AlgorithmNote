package recall;

import java.util.List;

public class _22_parentness_generation {
    class Solution {
        List<String> result=new ArrayList<>();
        public List<String> generateParenthesis(int n) {
            digui("",n*2,0);
            return result;
        }
        public void digui(String s,int n,int num){
            if(s.length()==n){
                result.add(s);
                return;
            }
            if(s.length()-num<n/2){
                digui(s+"(",n,num);
            }
            if(2*num<s.length()){
                digui(s+')',n,num+1);
            }
            return;
        }
    }
}
