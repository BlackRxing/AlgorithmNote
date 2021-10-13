package recall;

import java.util.ArrayList;
import java.util.List;

public class _93_restore_ip_address {
    class Solution {
        List<String> res=new ArrayList();
        List<String> path=new ArrayList();
        public boolean isValid(String s,int l,int r){
            if(s.charAt(l)=='0'&&l<r){      //长度大于2时，第一个字母不能是0
                return false;
            }
            int num=0;
            for(int i=l;i<=r;i++){
                if(s.charAt(i)>='0'&&s.charAt(i)<='9'){  //范围在0-9之间
                    num=num*10;
                    num+=s.charAt(i)-'0';
                }else{
                    return false;
                }
            }
            if(num<=255){
                return true;
            }
            return false;
        }
        public void backTracking(String s,int pos,int depth){
            if(depth==4){                   //
                if(pos==s.length()){
                    String ans="";
                    for(String i:path){
                        ans+=i;
                        ans+='.';
                    }
                    res.add(ans.substring(0,ans.length()-1));
                }else{
                    return;
                }
            }
            for(int i=1;i<=3;i++){
                if(pos<s.length()&&pos+i<=s.length()&&isValid(s,pos,pos+i-1)){  //监察长度防止溢出
                    path.add(s.substring(pos,pos+i));
                    backTracking(s,pos+i,depth+1);
                    path.remove(path.size()-1);
                }
            }
        }
        public List<String> restoreIpAddresses(String s) {
            backTracking(s,0,0);
            return res;
        }
    }
}
