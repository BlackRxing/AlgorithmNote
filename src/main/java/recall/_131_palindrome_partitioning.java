package recall;

import java.util.ArrayList;
import java.util.List;

public class _131_palindrome_partitioning {
    class Solution {
        List<List<String>> res=new ArrayList();
        List<String> path=new ArrayList();
        public boolean isPalindrome(String s,int start,int end){
            while(start<=end){
                if(s.charAt(start)!=s.charAt(end)){
                    return false;
                }
                start++;
                end--;
            }
            return true;
        }
        public List<List<String>> partition(String s) {
            backTracking(s,0);
            return res;
        }
        public void backTracking(String s,int pos){
            if(pos>=s.length()){
                res.add(new ArrayList(path));
            }
            for(int end=pos;end<s.length();end++){
                if(isPalindrome(s,pos,end)){
                    path.add(s.substring(pos,end+1));
                    backTracking(s,end+1);
                    path.remove(path.size()-1);
                }
            }
        }
    }
}
