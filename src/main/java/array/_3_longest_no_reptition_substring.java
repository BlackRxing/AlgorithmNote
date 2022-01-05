package array;

import java.util.Arrays;

//滑动窗口
public class _3_longest_no_reptition_substring {
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            int[] mark=new int[256];
            int result=0;
            Arrays.fill(mark,-1);
            int start=0;
            for(int i=0;i<s.length();i++){
                if(mark[s.charAt(i)-0]!=-1){
                    start=Math.max(mark[s.charAt(i)-0]+1,start);  //这一行特别容易错漏掉max，比如如果abba，当遍历到a时，start变成1，其实start应该是3！
                }
                mark[s.charAt(i)-0]=i;
                result=Math.max(result,i-start+1);
                System.out.println(i+" "+start);
            }
            return result;
        }
    }
}
//利用indexOf函数写起来更加简洁，indexOf（a，b） a是查找的子字符串，b是开始查找的位置，找不到返回-1
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int result=0;
        int start=0;
        for(int i=0;i<s.length();i++){
            int temp=s.indexOf(s.charAt(i),start);
            if(temp!=i&&temp>=0){
                start=s.indexOf(s.charAt(i),start)+1;
            }
            result=Math.max(result,i-start+1);
            System.out.println(i+" "+start+temp);
        }
        return result;
    }
}
