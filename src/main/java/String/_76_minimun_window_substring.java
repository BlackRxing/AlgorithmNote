package String;
//采用滑动窗口
//数据结构使用数组保存
//key1：使用count判断当前是否已经满足要求，而无需遍历数据结构来判断
//key2：对于查找的字母和其他普通字母统一处理，普通字母加入窗口后变成负数，然后排出窗口时加上即可，count变为0后不必区分字母类别，如果有查找的字母重复出现nums就变为负数，重新加上即可
public class _76_minimun_window_substring {
    class Solution {
        public String minWindow(String s, String t) {
            if(s.length()==0||t.length()==0||s==null||t==null){
                return "";
            }
            int l=0,r=0,result=Integer.MAX_VALUE,start=0,count=t.length(),end=0;
            int[] nums=new int[128];
            for(int i=0;i<t.length();i++){
                nums[t.charAt(i)]++;
            }
            while(r<s.length()){
                if(nums[s.charAt(r)]>0){
                    count--;
                }
                nums[s.charAt(r)]--;
                if(count==0){
                    while(l<r&&nums[s.charAt(l)]<0){
                        nums[s.charAt(l)]++;
                        l++;
                    }
                    if(result>(r-l+1)){
                        result=r-l+1;
                        start=l;
                        end=r+1;
                    }
                }
                r++;
            }
            return result==Integer.MAX_VALUE?"":s.substring(start,end);
        }
    }
}
