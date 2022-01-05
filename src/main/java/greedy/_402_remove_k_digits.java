package greedy;

import java.util.Stack;
//使用贪心加上stack
//寻找ai>ai+1并去掉ai，依次向后遍历，使用stack保存不减小的数组，时间复杂度达到n
public class _402_remove_k_digits {
    class Solution {
        public String removeKdigits(String num, int k) {
            Stack<Integer> stack=new Stack();
            for(char c:num.toCharArray()){
                int cur=c-'0';
                while(!stack.isEmpty()&&stack.peek()>cur&&k>0){  //条件注意
                    stack.pop();
                    k--;
                }
                stack.push(cur);
            }
            while(k>0){   //可能去的还不够，就只能从后面开始去
                stack.pop();
                k--;
            }
            String answer="";
            while(!stack.isEmpty()){
                answer=stack.pop()+answer;
            }
            for(int i=0;i<answer.length();i++){        //这一步是为了去掉前面的0000
                if(answer.charAt(i)!='0'||i==answer.length()-1){  //00000这样去0后最后还剩一个0，line32会处理
                    answer=answer.substring(i,answer.length());
                    break;
                }
            }
            if(answer==""||answer=="0"){  //可能没有数字，返回0
                return "0";
            }
            return answer;
        }
    }
}
