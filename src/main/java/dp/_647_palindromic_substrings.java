package dp;

public class _647_palindromic_substrings {
 //动态规划写法，只能记录每一种对错，直接用dp记录个数容易写成另一种问题，见第三个main
 public int countSubstrings(String s) {
     int len, ans = 0;
     if (s == null || (len = s.length()) < 1) return 0;
     //dp[i][j]：s字符串下标i到下标j的字串是否是一个回文串，即s[i, j]
     boolean[][] dp = new boolean[len][len];
     for (int j = 0; j < len; j++) {
         for (int i = 0; i <= j; i++) {
             //当两端字母一样时，才可以两端收缩进一步判断
             if (s.charAt(i) == s.charAt(j)) {
                 //i++，j--，即两端收缩之后i,j指针指向同一个字符或者i超过j了,必然是一个回文串
                 if (j - i < 3) {
                     dp[i][j] = true;
                 } else {
                     //否则通过收缩之后的字串判断
                     dp[i][j] = dp[i + 1][j - 1];
                 }
             } else {//两端字符不一样，不是回文串
                 dp[i][j] = false;
             }
         }
     }
     //遍历每一个字串，统计回文串个数
     for (int i = 0; i < len; i++) {
         for (int j = 0; j < len; j++) {
             if (dp[i][j]) ans++;
         }
     }
     return ans;
 }

//双指针中心扩散写法
class Solution {
    public int countSubstrings(String s) {
        int start,end;
        int ans=0;
        for(int i=0;i<2*s.length()-1;i++){
            if(i%2==0){
                start=i/2;
                end=i/2;
            }else{
                start=(i/2);
                end=(i/2+1);
            }
            while(start>=0&&end<s.length()&&s.charAt(start)==s.charAt(end)){ //容易写成if（s.charAt(start)==s.charAt(end)）{ ans++;},这是错误的
                ans++;
                start--;
                end++;
            }
        }
        return ans;
    }
}

    //误打误撞写出的另一个问题，子回文序列可以是离散的，比如aaa结果是7，而不是6
//    class Solution {
//        public int countSubstrings(String s) {
//            int length=s.length();
//            int[][] dp=new int[length][length];
//            for(int i=0;i<length;i++){
//                dp[i][i]=1;
//            }
//            for(int i=1;i<length;i++){
//                for(int j=0;j<length-i;j++){
//                    if(s.charAt(j)==s.charAt(j+i)){
//                        dp[j][j+i]=dp[j][j+i-1]+dp[j+1][j+i]+1;
//                    }else{
//                        dp[j][j+i]=dp[j][j+i-1]+dp[j+1][j+i]-dp[j+1][j+i-1];
//                    }
//                }
//            }
//            return dp[0][length-1];
//        }
    }
}
