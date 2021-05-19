package String;
//双指针或者构造新字符串，需要从后往前遍历#！写起来比较繁琐，注重逻辑。
public class _844_backspace_string_compare {
    class Solution {
        public boolean backspaceCompare(String s, String t) {
            int sjump=0,tjump=0;
            int sl=s.length()-1,tl=t.length()-1;
            while(sl>=0||tl>=0){   //也可以写成while（1），两者小于0的情况放入循环中讨论
                while(sl>=0){
                    if(s.charAt(sl)=='#'){
                        sjump++;
                        sl--;
                    }else if(sjump>0){
                        sjump--;
                        sl--;
                    }else{
                        break;
                    }
                }
                while(tl>=0){
                    if(t.charAt(tl)=='#'){
                        tjump++;
                        tl--;
                    }else if(tjump>0){
                        tjump--;
                        tl--;
                    }else{
                        break;
                    }
                }
                if(tl>=0&&sl>=0){
                    if(s.charAt(sl)==t.charAt(tl)){
                        tl--;
                        sl--;
                    }else{
                        return false;
                    }
                }else if(tl>=0||sl>=0){
                    return false;
                }
            }
            return true;
        }
    }
}
