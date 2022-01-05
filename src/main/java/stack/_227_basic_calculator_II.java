package stack;

import java.util.Stack;
//和逆波兰表达式很像
public class _227_basic_calculator_II {
    class Solution {
        public int calculate(String s) {
            int n=s.length();
            int result=0;
            int temp=0;
            char last='+';
            int num=0;
            Stack<Integer> stack=new Stack();
            for(int i=0;i<n;i++){
                char c=s.charAt(i);
                if(c>='0'&&c<='9'){
                    num=num*10+c-'0';
                }  //下一行写else是错误的，在最后一位是数字的情况下是错误的
                if((!Character.isDigit(c)&&c!=' ')||i==n-1){  //这里只有这样写才可以，一定要写的非常准确才能全部通过
                    switch (last){
                        case '+': stack.push(num); break;
                        case '-': stack.push(-num); break;
                        case '*': stack.push(stack.pop()*num);break;
                        case '/': stack.push(stack.pop()/num);break;
                    }
                    last=c;
                    num=0;
                }

            }
            while(!stack.isEmpty()){
                result+=stack.pop();
            }
            return result;
        }
    }

}
