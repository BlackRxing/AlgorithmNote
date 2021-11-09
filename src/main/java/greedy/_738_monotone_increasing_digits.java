package greedy;


public class _738_monotone_increasing_digits {
    class Solution {
        public int monotoneIncreasingDigits(int n) {
            int pre=10,cur=0,pos=0,step=0,loc=0,result=0,numres=0;
            int temp=n;
            while(n!=0){
                cur=n%10;
                step++;
                if(cur>pre){
                    loc=step;
                    numres=cur-1;
                    pre=cur-1;
                }else{
                    pre=cur;
                }
                n=n/10;
//                System.out.println(loc+" "+step+" "+n);
            }
            result=temp/(int)(Math.pow(10,loc));
            if(loc!=0){
                result=result*10+numres;
                for(int i=1;i<=loc-1;i++){
                    result=result*10+9;
                }
            }

            return result;
        }
    }
}
//数组转为字符串更容易遍历
class Solution {
    public int monotoneIncreasingDigits(int N) {
        String[] strings = (N + "").split("");
        int start = strings.length;
        for (int i = strings.length - 1; i > 0; i--) {
            if (Integer.parseInt(strings[i]) < Integer.parseInt(strings[i - 1])) {
                strings[i - 1] = (Integer.parseInt(strings[i - 1]) - 1) + "";
                start = i;
            }
        }
        for (int i = start; i < strings.length; i++) {
            strings[i] = "9";
        }
        return Integer.parseInt(String.join("",strings));
    }
}

